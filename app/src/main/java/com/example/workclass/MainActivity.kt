package com.example.workclass

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.workclass.data.DataBase.AppDatabase
import com.example.workclass.data.DataBase.DatabaseProvider
import com.example.workclass.ui.Screens.AccountsScreen
import com.example.workclass.ui.Screens.ComponentsScreen
import com.example.workclass.ui.Screens.FavoriteAccountsScreen
import com.example.workclass.ui.Screens.HomeScreen
import com.example.workclass.ui.theme.WorkClassTheme
import com.example.workclass.ui.Screens.MainMenuScreen
import com.example.workclass.ui.Screens.TestScreen
import com.example.workclass.ui.Screens.WattpadInterface
import com.example.workclass.ui.Screens.LoginScreen
import com.example.workclass.ui.Screens.ManageAccountScreen
import com.example.workclass.ui.Screens.Camara
import com.example.workclass.ui.Screens.appScreen
import com.example.workclass.ui.Screens.BiometricScreen
import com.example.workclass.ui.Screens.NotificationScreen

class MainActivity : FragmentActivity() {
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) !=
                android.content.pm.PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1001)
            }
        }
        super.onCreate(savedInstanceState)
        try{
            database = DatabaseProvider.getDatabase(this)
            Log.d("debug","Database loaded successfully")
        } catch(exception: Exception){
            Log.d("debug-db","Error: $exception")
        }
        //enableEdgeToEdge()
        setContent {
            WorkClassTheme {
                ComposableMultiScreenApp()
            }

        }
    }
}

@Composable
fun ComposableMultiScreenApp(){
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController=navController, startDestination= "main_menu"){
        composable("main_menu"){MainMenuScreen(navController) }
        composable("home_screen"){HomeScreen(navController) }
        composable("test_screen"){ TestScreen(navController) }
        composable("wattpad_interface"){ WattpadInterface(navController) }
        composable("components_screen"){ ComponentsScreen(navController) }
        composable("login_screen"){ LoginScreen(navController) }
        composable("accounts_screen"){ AccountsScreen(navController) }
        composable("manage_account_screen"){ ManageAccountScreen(navController) }
        composable(
            route = "manage_account_screen/{id}",
            arguments = listOf(navArgument("id") { defaultValue = -1 })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
            ManageAccountScreen(
                navController = navController,
                accountId = id
            )
        }
        composable("favorite_accounts_screen"){ FavoriteAccountsScreen(navController) }
        composable("camara_screen"){ Camara(navController) }
        composable("calendario_contactos_screen"){ appScreen(navController) }
        composable("biometric_screen") {
            val context = LocalContext.current
            BiometricScreen(navController, onAuthSuccess = {
                Toast.makeText(context, "¡Autenticación exitosa!", Toast.LENGTH_SHORT).show()
            })
        }
        composable("notification_screen"){ NotificationScreen(navController) }
    }
}
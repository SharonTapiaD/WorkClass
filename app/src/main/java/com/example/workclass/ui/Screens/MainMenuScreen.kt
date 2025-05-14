package com.example.workclass.ui.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MainMenuScreen(navController: NavHostController){
    /*Column(
        modifier= Modifier
            .padding(10.dp)
            .fillMaxSize()
    ){
        Text ("Main Menu Screen")
        Button(
            onClick = {navController.navigate("home_screen")}
        ) {
            Text("Go to Home Screen")
        }
        Button(
            onClick = {navController.navigate("test_screen")}
        ) {
            Text("Go to Test Screen")
        }
        Button(
            onClick = {navController.navigate("wattpad_interface")}
        ) {
            Text("Go to Wattpad Interface")
        }
        Button(
            onClick = {navController.navigate("components_screen")}
        ) {
            Text("Go to Components Screen")
        }
        Button(
            onClick = {navController.navigate("login_screen")}
        ) {
            Text("Go to Login Screen")
        }
        Button(
            onClick = {navController.navigate("accounts_screen")}
        ) {
            Text("Go to Accounts Screen")
        }
        Button(
            onClick = {navController.navigate("manage_account_screen")}
        ) {
            Text("Go to Manage Account Screen")
        }
        Button(
            onClick = {navController.navigate("favorite_accounts_screen")}
        ) {
            Text("Go to Favorite Account Screen")
        }
        Button(
            onClick = {navController.navigate("camara_screen")}
        ) {
            Text("Go to Camara Screen")
        }
        Button(
            onClick = {navController.navigate("calendario_contactos_screen")}
        ) {
            Text("Go to Calendar and Contacts Screen")
        }
        Button(
            onClick = {navController.navigate("notification_screen")}
        ) {
            Text("Go to Notification Screen")
        }
        Button(
            onClick = {navController.navigate("biometric_screen")}
        ) {
            Text("Go to Biometric Sensors Screen")
        }
    }*/
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFCEB9FF)),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Main Menu Screen",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        MenuItem("Home", Icons.Default.Home, "home_screen", navController)
        MenuItem("Test", Icons.Default.ThumbUp, "test_screen", navController)
        MenuItem("Wattpad", Icons.Default.Star, "wattpad_interface", navController)
        MenuItem("Components", Icons.Default.MoreVert, "components_screen", navController)
        MenuItem("Login", Icons.Default.Lock, "login_screen", navController)
        MenuItem("Accounts", Icons.Default.AccountBox, "accounts_screen", navController)
        MenuItem("Manage Account", Icons.Default.Email, "manage_account_screen", navController)
        MenuItem("Favorites", Icons.Default.Favorite, "favorite_accounts_screen", navController)
        MenuItem("Camera", Icons.Default.Face, "camara_screen", navController)
        MenuItem("Calendar", Icons.Default.DateRange, "calendario_contactos_screen", navController)
        MenuItem("Notifications", Icons.Default.Notifications, "notification_screen", navController)
        MenuItem("Biometric", Icons.Default.Check, "biometric_screen", navController)
    }
}

@Composable
fun MenuItem(label: String, icon: ImageVector, route: String, navController: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .clickable { navController.navigate(route) }
    ) {
        IconButton(onClick = { navController.navigate(route) }) {
            Icon(imageVector = icon, contentDescription = label)
        }
        Text(
            text = "Go to $label Screen",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
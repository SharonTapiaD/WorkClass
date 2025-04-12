package com.example.workclass.ui.Screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclass.data.ViewModel.AccountViewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.workclass.data.DataBase.AppDatabase
import com.example.workclass.data.DataBase.DatabaseProvider
import com.example.workclass.data.model.AccountModel
import com.example.workclass.data.model.toAccountEntity
import com.example.workclass.ui.Components.AccountCardComponent
import com.example.workclass.ui.Components.AccountDetailCardComponent
import com.example.workclass.ui.Components.TopBarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen(navController: NavController, viewModel: AccountViewModel = viewModel()){
    var accounts by remember{ mutableStateOf<List<AccountModel>>(emptyList()) }
    var showButtonSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var accountDetail by remember { mutableStateOf <AccountModel?> (null) }
    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()

    Column(){
        //Text("Account Screen")
        TopBarComponent("Accounts", navController, "accounts_screen")

        //AccountCardComponent(1, "Name", "user@gmail.com", "")
        LaunchedEffect(Unit) {
            viewModel.getAccounts { response ->
                if(response.isSuccessful){
                    accounts = response.body() ?: emptyList()
                } else {
                    Log.d("debug", "Failed to load data: ${response.code()}")
                }
            }
        }
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = listState
        ){
            items(accounts){ account ->
                AccountCardComponent(
                    account.id,
                    account.name,
                    account.username,
                    account.imageURL,
                    onButtonClick = {
                        viewModel.getAccount(account.id){ response ->
                            if(response.isSuccessful){
                                accountDetail = response.body()
                            }
                        }
                        showButtonSheet = true
                    }
                )
            }
        }
    }

    if(showButtonSheet){
        ModalBottomSheet(
            modifier = Modifier
                .fillMaxHeight(),
            onDismissRequest = {
                showButtonSheet = false
            },
            sheetState = sheetState
        ) {
            AccountDetailCardComponent(
                accountDetail?.id ?: 0,
                accountDetail?.name ?: "",
                accountDetail?.username ?: "",
                accountDetail?.password ?: "",
                accountDetail?.imageURL ?: "",
                accountDetail?.description ?: "",
                onSaveClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        try{
                            accountDetail?.let { accountDao.insert(it.toAccountEntity())}
                            Log.d("debug-db", "Account inserted successfully")
                        } catch(exception: Exception){
                            Log.d("debug-db", "ERROR: $exception")
                        }
                    }
                    showButtonSheet = false
                }
            )
        }
    }
}
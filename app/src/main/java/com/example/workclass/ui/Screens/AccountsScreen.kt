package com.example.workclass.ui.Screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclass.data.ViewModel.AccountViewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.workclass.data.model.AccountModel
import com.example.workclass.ui.Components.AccountCardComponent
import com.example.workclass.ui.Components.TopBarComponent

@Composable
fun AccountsScreen(navController: NavController, viewModel: AccountViewModel = viewModel()){
    var accounts by remember{ mutableStateOf<List<AccountModel>>(emptyList()) }
    Column(){
        //Text("Account Screen")
        TopBarComponent("Accounts")
        //AccountCardComponent(1, "Name", "user@gmail.com", "")
        LaunchedEffect(Unit) {
            viewModel.getAccounts { response ->
                if(response.isSuccessful){
                    accounts = response.body() ?: emptyList()
                } else {
                    Log.d("debug", "Failed to load data")
                }
            }
        }
    }
}
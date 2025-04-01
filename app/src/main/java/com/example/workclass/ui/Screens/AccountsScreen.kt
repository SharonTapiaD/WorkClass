package com.example.workclass.ui.Screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.navigation.NavController
import com.example.workclass.ui.Components.TopBarComponent

@Composable
fun AccountsScreen(navController: NavController){
    Column(){
        //Text("Account Screen")
        TopBarComponent("Accounts")
    }
}
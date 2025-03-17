package com.example.workclass.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.Text

@Composable
fun MainMenuScreen(navController: NavHostController){
    Column(
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
    }
}
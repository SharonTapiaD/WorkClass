package com.example.workclass.ui.Screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workclass.data.ViewModel.AccountViewModel
import com.example.workclass.data.model.AccountModel
import com.example.workclass.ui.Components.TopBarComponent

@Composable
fun ManageAccountScreen(
    navController: NavController,
    viewModel: AccountViewModel = viewModel()
){
    val account = remember { mutableStateOf(AccountModel()) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .fillMaxSize()
    ){
        TopBarComponent("Add account", navController, "manage_account_screen")

        OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
        value = account.value.name,
        maxLines = 1,
        label = {"Account Name"},
        onValueChange = {account.value = account.value.copy(name = it)}
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.username,
            maxLines = 1,
            label = {"Account User Name"},
            onValueChange = {account.value = account.value.copy(username = it)}
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.password,
            maxLines = 1,
            label = {"Account Password"},
            onValueChange = {account.value = account.value.copy(password = it)}
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = account.value.description,
            maxLines = 1,
            label = {"Account Description"},
            onValueChange = {account.value = account.value.copy(description = it)}
        )

        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            onClick = {
                TryCreateAccount(account, context, viewModel)
            }
        ) {
            Text(text = "Save Account")
        }
    }
}

fun TryCreateAccount(
    accountState: MutableState<AccountModel>,
    context: Context,
    viewModel: AccountViewModel
    ){
    val accountS = accountState.value

    if(
        accountS.name.isEmpty() ||
        accountS.username.isEmpty() ||
        accountS.password.isEmpty() ||
        accountS.description.isEmpty()
    ) {
        Toast.makeText(
            context,
            "None of the fields can be empty",
            Toast.LENGTH_SHORT
        ).show()
        return
    } else{
        viewModel.createAccount(accountS){ jsonResponse ->
            val createAccStatus = jsonResponse?.get("store")?.asString
            Log.d("debug", "Create account status: $createAccStatus")
            if(createAccStatus == "success"){
                Toast.makeText(
                    context,
                    "Account created successfully",
                    Toast.LENGTH_SHORT
                ).show()
            } else{
                Toast.makeText(
                    context,
                    "Error creating account",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
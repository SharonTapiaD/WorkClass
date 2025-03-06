package com.example.workclass.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ComponentsScreen(navController: NavHostController){
    Column(){
        //Buttons()
        //FloatingButtons()
        //Progress()
        //Chips()
        //Sliders()
        //Switches()
        //Badges()
        //SnackBars()
        //AlertDialogs()
        var option by remember { mutableStateOf("buttons") }
        var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        var scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text("Menu", modifier = Modifier.padding(16.dp))
                    HorizontalDivider()
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Buttons")},
                        selected = false,
                        onClick = {
                            option = "buttons"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Floating Buttons")},
                        selected = false,
                        onClick = {
                            option = "floating-buttons"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Progress")},
                        selected = false,
                        onClick = {
                            option = "progress"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Chips")},
                        selected = false,
                        onClick = {
                            option = "chips"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Sliders")},
                        selected = false,
                        onClick = {
                            option = "sliders"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Switches")},
                        selected = false,
                        onClick = {
                            option = "switches"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Badges")},
                        selected = false,
                        onClick = {
                            option = "badges"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("SnackBars")},
                        selected = false,
                        onClick = {
                            option = "snack-bars"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                    NavigationDrawerItem(
                        icon = {Icon(Icons.Filled.AccountBox, contentDescription = "")},
                        label = {Text("Alert Dialogs")},
                        selected = false,
                        onClick = {
                            option = "alertdialogs"
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                }
            }
        ) {
            Column{
                when (option){
                    "buttons" -> { Buttons() }
                    "floating-buttons" -> { FloatingButtons() }
                    "progress" -> { Progress() }
                    "chips" -> { Chips() }
                    "sliders" -> { Sliders() }
                    "switches" -> { Switches() }
                    "badges" -> { Badges() }
                    "snack-bars" -> { SnackBars() }
                    "alertdialogs" ->{ AlertDialogs() }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Buttons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton(onClick = {}) {
            Text("Outline")
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }
        TextButton(onClick = {}) {
            Text("Text")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun FloatingButtons(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        FloatingActionButton(onClick = {}) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add Button"
            )
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add Button"
            )
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add Button"
            )
        }
        ExtendedFloatingActionButton(onClick = {}) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add Button"
            )
            Text(
                text = "Button"
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Progress(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Chips(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        AssistChip(
            onClick = {},
            label = {Text("Assist Chip")},
            leadingIcon = {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected = selected,
            onClick = {selected = !selected},
            label = {Text("Filter Chip")},
            leadingIcon = if(selected){
                {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Assist Chip",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            } else{
                null
            }
        )
        InputChipExample("Dismiss", {})
    }
}

@Composable
fun InputChipExample(text: String, onDismiss:() -> Unit){
    var enabled by remember { mutableStateOf(true) }
    if(!enabled) return

    InputChip(
        label = {Text(text)},
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                modifier = Modifier
                    .size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Icon Person",
                modifier = Modifier
                    .size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

//@Preview(showBackground = true)
@Composable
fun Sliders(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var SliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = SliderPosition,
            onValueChange = {SliderPosition = it},
            steps = 10,
            valueRange = 0f .. 100f
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = SliderPosition.toString()
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Switches(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {checked = it}
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {checked2 = it},
            thumbContent = if(checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Switch Check",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else{
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Badges(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if(itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ){
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart icon"
            )
        }
        Button(
            onClick = {itemCount++}
        ) {
            Text("Agregar artículo")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun SnackBars(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message has been sent") }
        }
        Button(::launchSnackBar){
            Text("Send message")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AlertDialogs(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if(showAlertDialog){
            AlertDialog(
                icon = {Icon(Icons.Filled.Warning, contentDescription = "Warning Icon")},
                title = {Text("Confirm Deletion")},
                text = {Text("Are you sure you want to delete the file?")},
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
        Button(onClick = {showAlertDialog = true}){
            Text("Delete file")
        }
        Text(selectedOption)
    }
}
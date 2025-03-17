package com.example.workclass.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import java.util.Locale
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.workclass.R
import com.example.workclass.data.model.MenuModel
import com.example.workclass.data.model.PostCardModel
import com.example.workclass.ui.Components.PostCardCompactComponent
import com.example.workclass.ui.Components.PostCardComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import kotlin.math.exp
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.pullRefreshIndicatorTransform

@Composable
fun ComponentsScreen(navController: NavHostController){
    val menuOptions = arrayOf(
        MenuModel(1,"Buttons", "buttons", Icons.Filled.Favorite),
        MenuModel(2,"Floating Buttons", "floating-buttons", Icons.Filled.AccountBox),
        MenuModel(3,"Progress", "progress", Icons.Filled.Star),
        MenuModel(4,"Chips", "chips", Icons.Filled.FavoriteBorder),
        MenuModel(5,"Sliders", "sliders", Icons.Filled.Person),
        MenuModel(6,"Switches", "switches", Icons.Filled.Create),
        MenuModel(7,"Badges", "badges", Icons.Filled.ShoppingCart),
        MenuModel(8,"Snack Bars", "snack-bars", Icons.Filled.Add),
        MenuModel(9,"Alert Dialog", "alertdialogs", Icons.Filled.Warning),
        MenuModel(10,"Bars", "bars", Icons.Filled.Settings),
        MenuModel(11,"Text Fields", "text-field", Icons.Filled.ThumbUp),
        MenuModel(12, "Outlined Text Fields", "outlined-text-field", Icons.Filled.Info),
        MenuModel(13, "Auto Complete Text Fields", "auto-complete", Icons.Filled.AccountCircle),
        MenuModel(14, "Check Box", "check-box", Icons.Filled.Done),
        MenuModel(15, "Radio Buttons", "radio-buttons", Icons.Filled.Close),
        MenuModel(16, "Dropdown Model", "dropdown-model", Icons.Filled.Build),
        MenuModel(17,"Date Picker", "date-picker", Icons.Filled.DateRange),
        MenuModel(18, "Date Picker Colors", "date-picker-colors", Icons.Filled.ArrowDropDown),
        MenuModel(19, "Date Picker Dialog", "date-picker-dialog", Icons.Filled.Build),
        MenuModel(20, "Date Range Picker State", "date-range-picker-state", Icons.Filled.FavoriteBorder),
        MenuModel(21, "Pull To Refresh", "pull-to-refresh", Icons.Filled.Call),
        MenuModel(22, "Modal Bottom Sheet", "modal-bottom-sheet", Icons.Filled.Delete),
    )
        var option by remember { mutableStateOf("buttons") }
        var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        var scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text("Menu", modifier = Modifier.padding(16.dp))
                    HorizontalDivider()
                    LazyColumn {
                        items(menuOptions) { item ->
                            NavigationDrawerItem(
                                icon = { Icon(item.icon, contentDescription = "") },
                                label = { Text(item.title) },
                                selected = false,
                                onClick = {
                                    option = item.option
                                    scope.launch {
                                        drawerState.apply {
                                            close()
                                        }
                                    }
                                }
                            )
                        }
                    }
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
                    "bars" -> { Bars() }
                    "text-field" -> { textFields() }
                    "outlined-text-field" -> { outlinedTextFields() }
                    "auto-complete" -> { AutoCompleteTextFields() }
                    "check-box" -> { checkBoxes() }
                    "radio-buttons" -> { RadioButtons() }
                    "dropdown-model" -> { DropdownMenus() }
                    "date-picker" -> { datePickers() }
                    "date-picker-colors" -> { datePickerColors() }
                    "date-picker-dialog" -> { datePickerDialog() }
                    "date-range-picker-state" -> { dateRangePickerState() }
                    "pull-to-refresh" -> { pullRefresh() }
                    "modal-bottom-sheet" -> { modalBottomSheet() }
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
//@Preview(showBackground = true)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        LargeTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary
            ),
            title = {Text("Screen Title")},
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search button")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings button")
                }
            }
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ){
            Adaptive()
        }

        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {}
            ) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {}
            ) {
                Icon(imageVector = Icons.Filled.Create, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {}
            ) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {}
            ) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {}
            ) {
                Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "")
            }
        }
    }
}

@Composable
fun Adaptive(){
    var windowsSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    // Compact width < 600 dp Phone Portrait
    //Medium width >= 600 dp < 840 dp Tablet Portrait
    //Expanded width >= 840 dp Tablet Landscape

    //Compact height < 480 dp Phone Landscape
    //Medium height > 480 dp < 900 dp Tablet Landscape Phone Portrait
    //Expanded height >= 900 dp Tablet Portrait

    val arrayPost = arrayOf(
        PostCardModel(1,"title 1", "text 1", R.drawable.astridix),
        PostCardModel(2,"title 2", "text 2", R.drawable.astridix),
        PostCardModel(3,"title 3", "text 3", R.drawable.astridix),
        PostCardModel(4,"title 4", "text 4", R.drawable.astridix),
        PostCardModel(5,"title 5", "text 5", R.drawable.astridix),
        PostCardModel(6,"title 6", "text 6", R.drawable.astridix),
        PostCardModel(7,"title 7", "text 7", R.drawable.astridix),
        PostCardModel(8,"title 8", "text 8", R.drawable.astridix),
        PostCardModel(9,"title 9", "text 9", R.drawable.astridix)
    )

    if (width == WindowWidthSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(arrayPost){item -> PostCardComponent(item.id, item.title, item.text, item.image) }
        }
    } else if(height == WindowHeightSizeClass.COMPACT){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(arrayPost){item -> PostCardCompactComponent(item.id, item.title, item.text, item.image) }
        }
    }
}

//Include new components 12/03/25

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun textFields(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {text = it},
            label = {Text("Ingresa tu nombre")}
        )

        var password by remember { mutableStateOf("") }
        TextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Contraseña")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun outlinedTextFields(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text("Nombre") },
            isError = text.isEmpty(),
            supportingText = {
                if(text.isEmpty()){
                    Text("Este campo es obligatorio")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun AutoCompleteTextFields(){
    val countries = listOf("México", "España", "Argentina", "Colombia")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {selectedText = it},
                label = {Text("Selecciona un país")},
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {expanded = false}
            ) {
                countries.forEach { country ->
                    DropdownMenuItem(
                        text = { Text(country) },
                        onClick = {
                            selectedText = country
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun checkBoxes(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        var checked by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked,
            onCheckedChange = {checked = it}
        )
        var checked2 by remember { mutableStateOf(false) }
        Checkbox(
            checked = checked2,
            onCheckedChange = {checked2 = it}
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun RadioButtons(){
    val option = listOf("Opción 1", "Opción 2", "Opción 3")
    var selectedOption by remember { mutableStateOf(option[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        option.forEach{ option ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = {selectedOption = option}
                )
                Text(text = option, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun DropdownMenus(){
    val options = listOf("Opción 1", "Opción 2", "Opción 3")
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Box(){
            Button(onClick = {expanded = true}) {
                Text(selectedOption)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {expanded = false}
            ){
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption = option
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun datePickers(){
    val datePickerState = rememberDatePickerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        DatePicker(state = datePickerState)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val selectedDate = datePickerState.selectedDateMillis?.let {
                Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
            }
        }) {
            Text("Confirmar Fecha")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun datePickerColors(){
    val colors = DatePickerDefaults.colors(
        containerColor = Color.Black,
        titleContentColor = Color.White,
        headlineContentColor = Color.Cyan,
        weekdayContentColor = Color.Green,
        subheadContentColor = Color.Magenta
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        DatePicker(state = rememberDatePickerState(), colors = colors)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun datePickerDialog(){
    var showDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Button(onClick = { showDialog = true }){
            Text("Seleccionar Fecha")
        }

        if(showDialog){
            DatePickerDialog(
                onDismissRequest = {showDialog = false},
                confirmButton = {
                    TextButton(onClick = {showDialog = false}) {
                        Text("Aceptar")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun dateRangePickerState(){
    val rangePickerState = rememberDateRangePickerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        DateRangePicker(state = rangePickerState)
        Button(onClick = {
            val startDate = rangePickerState.selectedStartDateMillis?.let {
                Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
            }
            val endDate = rangePickerState.selectedEndDateMillis?.let {
                Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
            }
        }){
            Text("Confirmar rango")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
//@Preview(showBackground = true)
@Composable
fun pullRefresh(){
    var isRefreshing by remember { mutableStateOf(false) }
    var itemList by remember { mutableStateOf(List(10){it + 1})}
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            kotlinx.coroutines.GlobalScope.launch {
                delay(2000)
                itemList = (1..10).shuffled()
                isRefreshing = false
            }
        }
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            items(itemList){ item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ){
                    Text(
                        text = "Elemento $item",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun modalBottomSheet(){
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Button(onClick = {
        showBottomSheet = true},
        modifier = Modifier
            .padding(16.dp)){
        Text("Mostrar Bottom Sheet")
    }

    if(showBottomSheet){
        ModalBottomSheet(
            onDismissRequest = {showBottomSheet = false},
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Text("¡Este es un Bottom Modal Sheet!")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {showBottomSheet = false}){
                    Text("Cerrar")
                }
            }
        }
    }
}
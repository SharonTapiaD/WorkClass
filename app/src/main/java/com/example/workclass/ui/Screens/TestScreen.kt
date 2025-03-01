package com.example.workclass.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.workclass.R

@Composable
fun TestScreen (navController: NavHostController){
    Column (modifier= Modifier
        .padding(2.dp)
        .fillMaxSize()

    ){
        Column (){
            TextComposable("Sharon")
            TextComposable()
            TextComposable()
            TextComposable()
        }
        Row (){
            TextComposable()
            TextComposable()
            TextComposable()
            TextComposable()
        }
        Column (){
            ModifierExample1()
            ModifierExample3()
            CustomText()
            picture()
        }

    }
}
@Preview(showBackground = true)
@Composable
fun ModifierExample1(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable (onClick={ })
    ){
        Text("Hello World")
    }
}
fun clickAction (){
    println("Column Clicked")
}
@Preview(showBackground = true)
@Composable
fun TextComposable (name:String = "Empty"){
    Text ("Welcome")
    Text (name)
}
@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxHeight()
            .background(Color.Yellow)
            .border(width = 2.dp, color = Color.White)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        TextComposable("1")
        TextComposable("2")
        TextComposable("3")
        TextComposable("4")
    }

}
@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Box (
        modifier= Modifier
            .background(Color.Red)
            .padding(10.dp)
            .height(300.dp)
            .width(300.dp)
    ){
        Text("1", Modifier.align(Alignment.TopStart))
        Text("2", Modifier.align(Alignment.TopCenter))
        Text("3", Modifier.align(Alignment.TopEnd))
        Text("4", Modifier.align(Alignment.CenterStart))
        Text("5", Modifier.align(Alignment.Center))
        Text("6", Modifier.align(Alignment.CenterEnd))
        Text("7", Modifier.align(Alignment.BottomStart))
        Text("8", Modifier.align(Alignment.BottomCenter))
        Text("9", Modifier.align(Alignment.BottomEnd))


    }
}
@Preview(showBackground = true)
@Composable
fun CustomText() {
    Column(){
        Text(
            stringResource(R.string.sample_text),
            color = colorResource(R.color.purple_200),
            fontSize = 20.sp,
            fontStyle= FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold

        )
        val gradientColors = listOf(Color.Cyan, Color.Yellow, Color.DarkGray)
        Text(
            stringResource(R.string.sample_text),
            style= TextStyle(brush = Brush.linearGradient(colors = gradientColors))
        )
    }
}
@Preview(showBackground = true)
@Composable
fun picture(){
    Column (
        modifier= Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(300.dp)
    ){
        Image(
            modifier= Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.astridix),
            contentDescription= "Atridix",
            contentScale= ContentScale.FillHeight

        )
    }
}
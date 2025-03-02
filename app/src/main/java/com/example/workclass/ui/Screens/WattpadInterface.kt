package com.example.workclass.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workclass.R
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WattpadInterface(navController: NavHostController){
    Column(
        modifier= Modifier
            .padding(2.dp)
            .fillMaxSize()
    ){
        BarraSuperior()
        PQTGTodo()
        textoDulceOferta()
        dulceOferta()
        mejoresSelecciones()
        BarraInferior()
    }
}

@Preview(showBackground = true)
@Composable
fun BarraSuperior(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(R.drawable.wattpadlogo),
            contentDescription = "Logo Wattpad",
            modifier = Modifier
                .size(40.dp)
        )

        Button(
            onClick = {/*Prueba premium*/},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE6E6FA)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(36.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.rayo),
                contentDescription = "Prueba premium",
                modifier = Modifier
                    .size(18.dp)
            )
            Text(
                text = "Prueba premium",
                color = Color(0xFF7B61FF),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 4.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(R.drawable.box),
                contentDescription = "Regalo",
                modifier = Modifier
                    .size(32.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(R.drawable.perfil),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PQTGTodo(){
    Column(modifier = Modifier.padding(16.dp)){
        Text(
            text = "Porque te gusta de todo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        LazyRow {
            items(listaLibros) { libro -> LibroItem(libro)}
        }
    }
}

data class Libro(
    val titulo: String,
    val imagenRes: Int,
    val categoria: String
)

val listaLibros = listOf(
    Libro("Si me dices que no", R.drawable.simedicesqueno, "madrid"),
    Libro("Mi vecino es stripper", R.drawable.mivecinostripper, "itsbeautifulove"),
    Libro("A través de mi ventana", R.drawable.atravesventana1, "suspenso")
)

@Composable
fun LibroItem(libro: Libro){
    Column(
        modifier = Modifier
            .padding(end = 8.dp)
            .clickable { /*Acción al dar clic en el libro*/ }
    ){
        Image(
            painter = painterResource(id = libro.imagenRes),
            contentDescription = libro.titulo,
            modifier = Modifier
                .size(120.dp, 180.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = libro.categoria,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun textoDulceOferta(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = "Dulce oferta San Valentín! \uD83D\uDC96",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "¡30% de descuento en Premium mensual, ahora! \uD83D\uDC8C \uD83D\uDCD6",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun dulceOferta(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { /*Ir a la oferta*/ }
    ){
        Image(
            painter = painterResource(R.drawable.anuncio),
            contentDescription = "Dulce oferta de San Valentín",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun mejoresSelecciones() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Las mejores secciones para ti",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow {
            items(libros) { libro2 -> LibroItem2(libro2) }
        }
    }
}

data class Libros(
    val titulo: String,
    val imagenRes: Int
)

val libros = listOf(
    Libros("La no tan ordinaria vida de Tabitha", R.drawable.vidatabitha),
    Libros("Mi vecino es stripper", R.drawable.mivecinostripper),
    Libros("La maldición del cliché", R.drawable.maldicioncliche)
)

@Composable
fun LibroItem2(libro2: Libros) {
    Column(
        modifier = Modifier
            .padding(end = 8.dp)
            .clickable { /*Acción al dar clic en el libro*/ }
    ) {
        Image(
            painter = painterResource(id = libro2.imagenRes),
            contentDescription = libro2.titulo,
            modifier = Modifier
                .size(120.dp, 180.dp)
                .clip(RoundedCornerShape(8.dp)),
           // contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BarraInferior(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
            .border(2.dp, Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = Color(0xFFFFA07A),
            modifier = Modifier
                .size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.Gray,
            modifier = Modifier
                .size(24.dp)
        )
        Image(
            painter = painterResource(R.drawable.libreria),
            contentDescription = "Librería",
            modifier = Modifier
                .size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.Create,
            contentDescription = "Escribir",
            tint = Color.Gray,
            modifier = Modifier
                .size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notificaciones",
            tint = Color.Gray,
            modifier = Modifier
                .size(24.dp)
        )
    }
}
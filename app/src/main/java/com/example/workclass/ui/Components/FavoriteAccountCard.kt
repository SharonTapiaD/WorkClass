package com.example.workclass.ui.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.workclass.R

//@Preview(showBackground = true)
@Composable
fun FavoriteAccountCard(
    id: Int,
    name: String,
    username: String,
    password: String,
    description: String,
    imageURL: String,
    onDeleteClick: () -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                model = imageURL,
                error = painterResource(R.drawable.astridix),
                contentDescription = "Service Logo",
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "Account Service",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        IconButton(onClick = {
            onDeleteClick()
        }) {
            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Account")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Name",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Username",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = username,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Password",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = password,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Description",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = description,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
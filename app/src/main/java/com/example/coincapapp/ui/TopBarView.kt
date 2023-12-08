package com.example.coincapapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.coincapapp.R

@Composable
fun TopBarView(
    title: String,
    onBackNavigation: () -> Unit
){
    val navigationIcon : (@Composable () -> Unit)? = 
        if(!title.contains("Coin Cap")) {
            {
            IconButton(onClick = { onBackNavigation }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        } else{
        null
    }
    
    TopAppBar (
        title = {
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        },
        elevation = 4.dp,
        navigationIcon = navigationIcon,
        backgroundColor = colorResource(id = R.color.teal_700)
    )
}
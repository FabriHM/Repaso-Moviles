package com.example.repaso.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.repaso.R
import com.example.repaso.ui.navigation.AppScreen

@Composable
fun Home(navController: NavController){
    Image(
        painter = painterResource(id = R.mipmap.logo_2), // Reemplaza con tu imagen de branding
        contentDescription = null,
        modifier = Modifier.fillMaxWidth().height(200.dp)
    )
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                // Acción al hacer clic en "Find Product"
                navController.navigate(route = AppScreen.Search.route)
            },
        ) {
            Text("Find Product")
        }

        Button(
            onClick = {
                // Acción al hacer clic en "Favourite Product"

            }
        ) {
            Text("Favourite Product")
        }
    }
}
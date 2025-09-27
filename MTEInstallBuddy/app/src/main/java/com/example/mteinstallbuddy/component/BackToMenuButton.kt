package com.example.mteinstallbuddy.component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mteinstallbuddy.Screen

@Composable
fun BackToMenuButton(navController: NavHostController, modifier: Modifier = Modifier) {
    Button(
        onClick = { navController.navigate(Screen.Menu.route) },
        modifier = modifier
            .padding(top = 16.dp)
    ) {
        Text("🏠 Back to Main Menu")
    }
}
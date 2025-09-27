package com.example.mteinstallbuddy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mteinstallbuddy.R
import com.example.mteinstallbuddy.Screen

@Composable
fun MainMenuScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.meyer_logo),
                            contentDescription = "Meyer Truck Equipment Logo",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text("MTE Install Buddy")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate(Screen.Dashboard.route) }) {
                Text("📄 View Install Sheets")
            }
            Button(onClick = { navController.navigate(Screen.CreateInstall.route) }) {
                Text("🆕 Create New Install Sheet")
            }
            Button(onClick = { navController.navigate(Screen.Preferences.route) }) {
                Text("⚙️ Preferences")
            }
            Button(onClick = { navController.navigate(Screen.Help.route) }) {
                Text("❓ Help")
            }
        }
    }
}
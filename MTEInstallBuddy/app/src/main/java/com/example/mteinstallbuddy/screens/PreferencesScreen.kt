package com.example.mteinstallbuddy.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mteinstallbuddy.components.BackToMenuButton

@Composable
fun PreferencesScreen(navController: NavHostController) {
    val context = LocalContext.current
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    var showAdvanced by remember { mutableStateOf(prefs.getBoolean("showAdvanced", false)) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Preferences") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Show Advanced Fields")
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = showAdvanced,
                    onCheckedChange = {
                        showAdvanced = it
                        prefs.edit().putBoolean("showAdvanced", it).apply()
                    }
                )
            }
            BackToMenuButton(navController)
        }
    }
}
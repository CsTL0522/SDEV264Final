package com.example.mteinstallbuddy.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import com.example.mteinstallbuddy.component.BackToMenuButton
import androidx.compose.runtime.saveable.rememberSaveable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferencesScreen(navController: NavHostController) {
    val context = LocalContext.current
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    var technicianName by rememberSaveable {
        mutableStateOf(prefs.getString("technicianName", "") ?: "")
    }

    var defaultInstallType by rememberSaveable {
        mutableStateOf(prefs.getString("defaultInstallType", "Standard") ?: "Standard")
    }

    var autoSync by rememberSaveable {
        mutableStateOf(prefs.getBoolean("autoSync", true))
    }

    var autoTimestamp by rememberSaveable {
        mutableStateOf(prefs.getBoolean("autoTimestamp", true))
    }

    var showAdvanced by rememberSaveable {
        mutableStateOf(prefs.getBoolean("showAdvanced", false))
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Preferences") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Technician Name
            OutlinedTextField(
                value = technicianName,
                onValueChange = {
                    technicianName = it
                    prefs.edit { putString("technicianName", it) }
                },
                label = { Text("Technician Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // Default Install Type
            OutlinedTextField(
                value = defaultInstallType,
                onValueChange = {
                    defaultInstallType = it
                    prefs.edit { putString("defaultInstallType", it) }
                },
                label = { Text("Default Install Type") },
                modifier = Modifier.fillMaxWidth()
            )

            // Auto-Sync Toggle
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Enable Auto-Sync")
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = autoSync,
                    onCheckedChange = {
                        autoSync = it
                        prefs.edit { putBoolean("autoSync", it) }
                    }
                )
            }

            // Auto-Timestamp Toggle
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Auto-Timestamp New Installs")
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = autoTimestamp,
                    onCheckedChange = {
                        autoTimestamp = it
                        prefs.edit { putBoolean("autoTimestamp", it) }
                    }
                )
            }

            // Show Advanced Fields Toggle
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Show Advanced Fields")
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = showAdvanced,
                    onCheckedChange = {
                        showAdvanced = it
                        prefs.edit { putBoolean("showAdvanced", it) }
                    }
                )
            }

            Spacer(Modifier.weight(1f))
            BackToMenuButton(navController)
        }
    }
}
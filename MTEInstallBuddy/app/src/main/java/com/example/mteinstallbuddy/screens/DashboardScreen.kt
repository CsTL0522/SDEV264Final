package com.example.mteinstallbuddy.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mteinstallbuddy.component.BackToMenuButton
import com.example.mteinstallbuddy.viewmodel.InstallViewModel
import com.example.mteinstallbuddy.viewmodel.InstallViewModelFactory
import java.text.DateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel: InstallViewModel = viewModel(factory = InstallViewModelFactory(context.applicationContext as Application))
    val installs by viewModel.installs.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Install Dashboard", color = MaterialTheme.colorScheme.onPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(installs.size) { index ->
                    val install = installs[index]
                    val formattedDate = DateFormat.getDateTimeInstance().format(Date(install.timestamp))

                    Surface(
                        tonalElevation = 4.dp,
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                "${install.make} ${install.model} - ${install.type}",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text("Tech: ${install.technician}", style = MaterialTheme.typography.bodyMedium)
                            Text("Notes: ${install.notes}", style = MaterialTheme.typography.bodyMedium)
                            Text("Created: $formattedDate", style = MaterialTheme.typography.labelLarge)

                            install.photoUri?.let {
                                AsyncImage(
                                    model = it,
                                    contentDescription = "Install Photo",
                                    modifier = Modifier
                                        .size(100.dp)
                                        .padding(top = 8.dp)
                                )
                            }
                        }
                    }
                }
            }

            BackToMenuButton(navController)
        }
    }
}
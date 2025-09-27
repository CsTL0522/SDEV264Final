package com.example.mteinstallbuddy.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mteinstallbuddy.viewmodel.InstallViewModel
import com.example.mteinstallbuddy.viewmodel.InstallViewModelFactory
import com.example.mteinstallbuddy.components.BackToMenuButton

@Composable
fun DashboardScreen(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel: InstallViewModel = viewModel(factory = InstallViewModelFactory(context.applicationContext as Application))
    val installs by viewModel.installs.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadInstalls()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Install Dashboard") })
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
                    Column(modifier = Modifier.padding(vertical = 8.dp)) {
                        Text("${install.make} ${install.model} - ${install.type}", style = MaterialTheme.typography.titleMedium)
                        Text("Tech: ${install.technician}")
                        Text("Notes: ${install.notes}")
                        install.photoUri?.let {
                            AsyncImage(
                                model = it,
                                contentDescription = "Install Photo",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(top = 4.dp)
                            )
                        }
                    }
                    Divider()
                }
            }

            BackToMenuButton(navController)
        }
    }
}
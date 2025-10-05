package com.example.mteinstallbuddy.screens

import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel: InstallViewModel = viewModel(factory = InstallViewModelFactory(context.applicationContext as Application))
    val installs by viewModel.installs.collectAsState()


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
                    HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
                }
            }

            BackToMenuButton(navController)
        }
    }
}
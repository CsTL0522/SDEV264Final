package com.example.mteinstallbuddy.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mteinstallbuddy.components.BackToMenuButton
import com.example.mteinstallbuddy.viewmodel.InstallViewModel
import com.example.mteinstallbuddy.viewmodel.InstallViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateInstallScreen(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel: InstallViewModel = viewModel(factory = InstallViewModelFactory(context.applicationContext as Application))

    val makes by viewModel.uniqueMakes.collectAsState()
    val models by viewModel.uniqueModels.collectAsState()
    val types by viewModel.uniqueTypes.collectAsState()

    var selectedMake by remember { mutableStateOf("") }
    var selectedModel by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf("") }

    var showMakeDropdown by remember { mutableStateOf(false) }
    var showModelDropdown by remember { mutableStateOf(false) }
    var showTypeDropdown by remember { mutableStateOf(false) }

    Scaffold(topBar = { TopAppBar(title = { Text("Create Install Sheet") }) }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Make
            ExposedDropdownMenuBox(
                expanded = showMakeDropdown,
                onExpandedChange = { showMakeDropdown = !showMakeDropdown }
            ) {
                OutlinedTextField(
                    value = selectedMake,
                    onValueChange = { selectedMake = it },
                    label = { Text("Make") },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = showMakeDropdown,
                    onDismissRequest = { showMakeDropdown = false }
                ) {
                    makes.forEach { make ->
                        DropdownMenuItem(
                            text = { Text(make) },
                            onClick = {
                                selectedMake = make
                                showMakeDropdown = false
                            }
                        )
                    }
                }
            }

            // Model
            ExposedDropdownMenuBox(
                expanded = showModelDropdown,
                onExpandedChange = { showModelDropdown = !showModelDropdown }
            ) {
                OutlinedTextField(
                    value = selectedModel,
                    onValueChange = { selectedModel = it },
                    label = { Text("Model") },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = showModelDropdown,
                    onDismissRequest = { showModelDropdown = false }
                ) {
                    models.forEach { model ->
                        DropdownMenuItem(
                            text = { Text(model) },
                            onClick = {
                                selectedModel = model
                                showModelDropdown = false
                            }
                        )
                    }
                }
            }

            // Type
            ExposedDropdownMenuBox(
                expanded = showTypeDropdown,
                onExpandedChange = { showTypeDropdown = !showTypeDropdown }
            ) {
                OutlinedTextField(
                    value = selectedType,
                    onValueChange = { selectedType = it },
                    label = { Text("Type") },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = showTypeDropdown,
                    onDismissRequest = { showTypeDropdown = false }
                ) {
                    types.forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type) },
                            onClick = {
                                selectedType = type
                                showTypeDropdown = false
                            }
                        )
                    }
                }
            }

            Button(onClick = {
                navController.navigate("install_detail?make=$selectedMake&model=$selectedModel&type=$selectedType")
            }) {
                Text("Next")
            }

            Spacer(Modifier.weight(1f))
            BackToMenuButton(navController)
        }
    }
}
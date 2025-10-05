package com.example.mteinstallbuddy.screens

import android.app.Application
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.mteinstallbuddy.component.BackToMenuButton
import com.example.mteinstallbuddy.data.InstallSheet
import com.example.mteinstallbuddy.viewmodel.InstallViewModel
import com.example.mteinstallbuddy.viewmodel.InstallViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstallDetailScreen(navController: NavHostController, entry: NavBackStackEntry) {
    val context = LocalContext.current
    val viewModel: InstallViewModel = viewModel(factory = InstallViewModelFactory(context.applicationContext as Application))

    val make = entry.arguments?.getString("make") ?: ""
    val model = entry.arguments?.getString("model") ?: ""
    val type = entry.arguments?.getString("type") ?: ""

    var technician by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    var photoUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(PickVisualMedia()) { uri ->
        photoUri = uri
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Install Details") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Make: $make")
            Text("Model: $model")
            Text("Type: $type")

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = technician,
                onValueChange = { technician = it },
                label = { Text("Technician Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Install Notes") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            Button(onClick = {
                launcher.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
            }) {
                Text("Attach Photo")
            }

            photoUri?.let {
                Spacer(Modifier.height(8.dp))
                Text("Photo attached: ${it.lastPathSegment}")
            }

            Spacer(Modifier.height(16.dp))

            Button(onClick = {
                val sheet = InstallSheet(
                    make = make,
                    model = model,
                    type = type,
                    technician = technician,
                    notes = notes,
                    photoUri = photoUri?.toString()
                )
                viewModel.saveInstall(sheet)
                navController.popBackStack("dashboard", false)
            }) {
                Text("Save Install Sheet")
            }
            BackToMenuButton(navController)
        }
    }
}
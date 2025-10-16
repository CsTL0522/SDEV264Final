package com.example.mteinstallbuddy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mteinstallbuddy.R
import com.example.mteinstallbuddy.component.BackToMenuButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Help & Support") })
        }
    ) { padding ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.meyer_logo),
                contentDescription = "Meyer Truck Equipment Logo",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "We Make Your Truck Work for You",
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center
            )

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

            Text(
                text = """
                    This app is designed with the builder in mind. To streamline the install process,
                    it allows each installer to document and read installs of varying equipment to assist in the
                    quality and repetition of Meyer as a whole across its varying locations.

                    Need help using the app?

                    • Tap 'Create Install Sheet' to start a new entry.
                    • Use 'Dashboard' to view saved sheets.
                    • Attach photos during install entry.
                    • Use 'Preferences' to customize your experience:
                      - Set default install types and truck models.
                      - Enable photo reminders during sheet creation.
                      - Choose your preferred sort order for saved sheets.

                    For support, contact:
                    support@meyertruckequipment.com
                    (812) 867-3901
                """.trimIndent(),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start
            )

            Spacer(Modifier.height(24.dp))

            BackToMenuButton(navController)
        }
    }
}
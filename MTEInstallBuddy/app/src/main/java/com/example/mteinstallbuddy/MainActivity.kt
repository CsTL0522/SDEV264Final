package com.example.mteinstallbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.mteinstallbuddy.screens.*
import com.example.mteinstallbuddy.ui.theme.MTEInstallBuddyTheme
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MTEInstallBuddyTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.Menu.route) {
                    composable(Screen.Menu.route) {
                        MainMenuScreen(navController)
                    }
                    composable(Screen.Dashboard.route) {
                        DashboardScreen(navController)
                    }
                    composable(Screen.CreateInstall.route) {
                        CreateInstallScreen(navController)
                    }
                    composable(Screen.Preferences.route) {
                        PreferencesScreen(navController)
                    }
                    composable(Screen.Help.route) {
                        HelpScreen(navController)
                    }
                    composable(
                        route = "install_detail?make={make}&model={model}&type={type}",
                        arguments = listOf(
                            navArgument("make") { type = NavType.StringType },
                            navArgument("model") { type = NavType.StringType },
                            navArgument("type") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        InstallDetailScreen(navController, backStackEntry)
                    }
                }
            }
        }
    }
}
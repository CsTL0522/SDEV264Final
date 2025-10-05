package com.example.mteinstallbuddy

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mteinstallbuddy.screens.*
import com.example.mteinstallbuddy.ui.theme.MTEInstallBuddyTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MTEInstallBuddyTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "splash") {
                    composable("splash") {
                        SplashScreen(navController)
                    }
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
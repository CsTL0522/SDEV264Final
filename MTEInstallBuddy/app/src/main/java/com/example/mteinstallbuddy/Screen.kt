package com.example.mteinstallbuddy

sealed class Screen(val route: String) {
    object Menu : Screen("menu")
    object Dashboard : Screen("dashboard")
    object CreateInstall : Screen("create_install")
    object Preferences : Screen("preferences")
    object Help : Screen("help")
}
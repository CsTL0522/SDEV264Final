package com.example.mteinstallbuddy.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val MeyerLightColors = lightColorScheme(
    primary = MeyerBlue,
    onPrimary = MeyerWhite,
    secondary = MeyerNavy,
    onSecondary = MeyerWhite,
    background = MeyerBackground,
    surface = MeyerWhite
)

@Composable
fun MTEInstallBuddyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MeyerLightColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
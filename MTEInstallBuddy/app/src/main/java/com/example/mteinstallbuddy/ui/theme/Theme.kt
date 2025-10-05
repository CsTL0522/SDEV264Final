package com.example.mteinstallbuddy.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


private val MeyerLightColors = lightColorScheme(
    primary = MeyerBlue,
    onPrimary = MeyerWhite,
    secondary = MeyerNavy,
    onSecondary = MeyerWhite,
    background = MeyerBackground,
    surface = MeyerWhite
)

private val MeyerShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

private val MeyerTypography = Typography()

@Composable
fun MTEInstallBuddyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MeyerLightColors,
        typography = MeyerTypography,
        shapes = MeyerShapes,
        content = content
    )
}
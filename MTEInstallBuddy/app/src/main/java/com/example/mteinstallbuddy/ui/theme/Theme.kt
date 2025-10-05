package com.example.mteinstallbuddy.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val MeyerLightColors = lightColorScheme(
    primary = MeyerBlue,
    onPrimary = MeyerWhite,
    secondary = MeyerNavy,
    onSecondary = MeyerWhite,
    background = MeyerBackground,
    onBackground = MeyerBlack,
    surface = MeyerWhite,
    onSurface = MeyerBlack
)

private val MeyerShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

private val MeyerTypography = Typography(
    titleLarge = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
    bodyMedium = TextStyle(fontSize = 16.sp),
    labelLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
)

@Composable
fun MTEInstallBuddyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MeyerLightColors,
        typography = MeyerTypography,
        shapes = MeyerShapes,
        content = content
    )
}
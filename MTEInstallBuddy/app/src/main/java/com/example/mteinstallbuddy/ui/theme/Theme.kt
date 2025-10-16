package com.example.mteinstallbuddy.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.OutlinedTextFieldDefaults

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

val InstallFieldColors
    @Composable get() = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        cursorColor = MaterialTheme.colorScheme.primary
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
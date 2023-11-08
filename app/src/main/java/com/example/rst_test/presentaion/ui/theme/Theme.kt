package com.example.rst_test.presentaion.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Color.LuckyPoint,
    secondary = Color.Pampas,
    background = Color.Black,
    onBackground = Color.WhiteType,
    tertiary = Color.DarkAccent,
    onSecondary = Color.UnselectedDark,
    surface = Color.Black,
    scrim = Color.DarkRed,
    outlineVariant = Color.DarkDivider,
    primaryContainer = Color.DarkContainerColor,
    outline = Color.DarkButtonStrokeColor,
    tertiaryContainer = Color.DarkButtonColor
)

private val LightColorScheme = lightColorScheme(
    primary = Color.LuckyPoint,
    secondary = Color.Pampas,
    background = Color.White,
    onBackground = Color.BlackType,
    tertiary = Color.LightAccent,
    onSecondary = Color.UnselectedLight,
    surface = Color.White,
    scrim = Color.LightRed,
    outlineVariant = Color.LightDivider,
    primaryContainer = Color.LightContainerColor,
    outline = Color.LightButtonStrokeColor,
    tertiaryContainer = Color.LightButtonColor
)

@Composable
fun RSTTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    if (darkTheme) {
        systemUiController.setSystemBarsColor(color = colorScheme.background, darkIcons = false)
    } else {
        systemUiController.setSystemBarsColor(color = colorScheme.background, darkIcons = true)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
package com.maxstudio.app.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val StudioColors = darkColorScheme(
    primary = Color(0xFF9B83FF),
    onPrimary = Color(0xFF170B3B),
    secondary = Color(0xFF55D8F2),
    background = Color(0xFF0B0B12),
    surface = Color(0xFF181A24),
    onBackground = Color(0xFFF5F7FB),
    onSurface = Color(0xFFF5F7FB)
)

@Composable
fun MaxStudioTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = StudioColors, content = content)
}

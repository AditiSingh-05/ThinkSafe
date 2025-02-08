package com.yourapp.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Light Theme Colors
// Light Theme Colors
val LightBackground1 = Color(0xFFD4D0DA) // Soft Lavender
val LightBackground2 = Color(0xFFD5A0EC) // Light Purple
val LightBackground3 = Color(0xFF9B36E3) // Vibrant Purple
val LightButtonContainer = Color(0xFF42044B) // Deep Purple for buttons
val LightWarningsColor = Color(0xFFEA1616) // Bright Red for warnings
val LightWhite = Color.White // True White for text
val LightBlack = Color.Black // True Black

// Define Light Color Scheme
val LightColorScheme = lightColorScheme(
    primary = LightBackground1,
    secondary = LightBackground2,
    background = LightBackground3,
    surface = LightButtonContainer,
    onPrimary = LightWarningsColor,
    onSecondary = LightWhite,
    onBackground = LightBlack,

)


// Dark Theme Colors
val DarkBackground1 = Color(0xFF1E1E1E)  // Dark Gray
val DarkBackground2 = Color(0xFF292929)  // Slightly lighter Gray
val DarkBackground3 = Color(0xFF373737)  // Even lighter Gray
val DarkButtonContainer = Color(0xFF620E73) // Deep Purple for buttons
val DarkWarningsColor = Color(0xFFFF4C4C) // Bright Red for warnings
val DarkWhite = Color(0xFFE0E0E0) // Soft White for text
val DarkBlack = Color.Black // True Black

// Define Dark Color Scheme
val DarkColorScheme = darkColorScheme(
    primary = DarkBackground1,
    secondary = DarkBackground2,
    background = DarkBackground3,
    surface = DarkButtonContainer,
    onPrimary = DarkWarningsColor,
    onSecondary = DarkWhite
)


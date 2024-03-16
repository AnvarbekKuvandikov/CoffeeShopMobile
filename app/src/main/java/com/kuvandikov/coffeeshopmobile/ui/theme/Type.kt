package com.kuvandikov.coffeeshopmobile.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kuvandikov.coffeeshopmobile.R


val soraFamily = FontFamily(
    Font(R.font.sora_bold, FontWeight.Bold),
    Font(R.font.sora_extra_bold, FontWeight.ExtraBold),
    Font(R.font.sora_extra_light, FontWeight.ExtraLight),
    Font(R.font.sora_light, FontWeight.Light),
    Font(R.font.sora_medium, FontWeight.Medium),
    Font(R.font.sora_regular, FontWeight.Normal),
    Font(R.font.sora_semi_bold, FontWeight.SemiBold),
    Font(R.font.sora_thin, FontWeight.Thin)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = soraFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = soraFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 34.sp
    ),
    labelSmall = TextStyle(
        fontFamily = soraFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)


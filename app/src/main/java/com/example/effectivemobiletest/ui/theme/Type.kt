package com.example.effectivemobiletest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletest.R

// Set of Material typography styles to start with
val Typography =
    Typography(
        bodyLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
     */
    )
val Roboto =
    FontFamily(
        Font(R.font.roboto, weight = FontWeight.Normal),
        Font(R.font.roboto_medium, weight = FontWeight.Medium),
        Font(R.font.roboto_mono_semibold, weight = FontWeight.SemiBold),
    )

val EffectiveMobileTypography =
    Typography(
        headlineLarge =
            TextStyle(
                fontFamily = Roboto,
                fontSize = 28.sp,
                lineHeight = 36.sp,
                fontWeight = FontWeight.Normal,
            ),
        titleLarge =
            TextStyle(
                fontFamily = Roboto,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Normal,
            ),
        titleMedium =
            TextStyle(
                fontFamily = Roboto,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium,
            ),
        displayMedium =
            TextStyle(
                fontFamily = Roboto,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = Roboto,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Normal,
            ),
        displaySmall =
            TextStyle(
                fontFamily = Roboto,
                fontSize = 12.sp,
                lineHeight = 15.sp,
                fontWeight = FontWeight.Normal,
            ),
        bodySmall =
            TextStyle(
                fontFamily = Roboto,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Normal,
            ),
    )

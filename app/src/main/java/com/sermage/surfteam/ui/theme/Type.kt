package com.sermage.surfteam.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sermage.surfteam.R

val sfProText = FontFamily(
    Font(R.font.sf_pro_text_regular, weight = FontWeight.Normal),
    Font(R.font.sf_pro_text_semibold, weight = FontWeight.SemiBold),
    Font(R.font.sf_pro_text_bold, weight = FontWeight.Bold),
    Font(R.font.sf_pro_text_heavy, weight = FontWeight.ExtraBold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = sfProText,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = sfProText,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    ),
    h1 = TextStyle(
        fontFamily = sfProText,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    ),
    h2 = TextStyle(
        fontFamily = sfProText,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = sfProText,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = sfProText,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

package com.joshMuleshi.ecodim.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.joshMuleshi.ecodim.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
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

val DancingScript = FontFamily(
    Font(R.font.dancing_script, FontWeight.Light),
    Font(R.font.dancing_script, FontWeight.Normal),
    Font(R.font.dancing_script, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.dancing_script, FontWeight.Medium),
    Font(R.font.dancing_script, FontWeight.Bold)
)

val Satisfy = FontFamily(
    Font(R.font.satisfy, FontWeight.Light),
    Font(R.font.satisfy, FontWeight.Normal),
    Font(R.font.satisfy, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.satisfy, FontWeight.Medium),
    Font(R.font.satisfy, FontWeight.Bold)
)

val FugazOne = FontFamily(
    Font(R.font.fugaz_one, FontWeight.Light),
    Font(R.font.fugaz_one, FontWeight.Normal),
    Font(R.font.fugaz_one, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.fugaz_one, FontWeight.Medium),
    Font(R.font.fugaz_one, FontWeight.Bold)
)

val Quicksand = FontFamily(
    Font(R.font.quicksand, FontWeight.Light),
    Font(R.font.quicksand, FontWeight.Normal),
    Font(R.font.quicksand, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.quicksand, FontWeight.Medium),
    Font(R.font.quicksand, FontWeight.Bold)
)

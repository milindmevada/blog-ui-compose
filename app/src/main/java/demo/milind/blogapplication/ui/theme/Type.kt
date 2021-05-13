package demo.milind.blogapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import demo.milind.blogapplication.R

private val Metropolis = FontFamily(
    Font(R.font.metropolis_black, FontWeight.W800),
    Font(R.font.metropolis_regular, FontWeight.W400),
    Font(R.font.metropolis_medium, FontWeight.W500),
)

val Typography = Typography(
    h5 = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.W800,
        fontSize = 24.sp,
        lineHeight = 32.78.sp,
        color = BlueDark,
    ),
    h6 = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.W800,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        color = BlueDark,
    ),
    body1 = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 19.12.sp,
        color = BlueDarkText,
    ),
    body2 = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        color = BlueDarkText,
    ),
    caption = TextStyle(
        fontFamily = Metropolis,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.39.sp,
        color = CaptionText,
    ),
)
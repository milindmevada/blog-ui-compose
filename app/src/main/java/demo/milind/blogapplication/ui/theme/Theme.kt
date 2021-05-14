package demo.milind.blogapplication.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val LightColorPalette = lightColors(
    primary = Blue,
    primaryVariant = BlueDark,
    secondary = BlueDarkText,
    background = ScaffoldBackground,
    onBackground = BlueDarkText,
)

@Composable
fun BlogApplicationTheme(
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
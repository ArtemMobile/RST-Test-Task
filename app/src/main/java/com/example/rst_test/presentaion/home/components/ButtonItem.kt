package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rst_test.R
import com.example.rst_test.data.dto.main.Button
import com.example.rst_test.presentaion.shared_components.shimmerEffect
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun ButtonItem(button: Button, onClick: () -> Unit = {}, modifier : Modifier) {
    val darkTheme = isSystemInDarkTheme()
    val brush =
        if (darkTheme) DarkThemeColorCodeToHex(button.color) else LightThemeColorCodeToHex(
            button.color
        )
    Row(
        modifier = modifier.clickable { onClick() }.background(
            brush = Brush.horizontalGradient(brush),
            shape = RoundedCornerShape(8.dp)
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val contentColor =
            if (darkTheme) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.background
        val icon = getIcon(button.icon)
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            Modifier.padding(start = 8.dp),
        )
        Text(
            text = button.title,
            color = contentColor,
            modifier = Modifier.padding(start = 8.dp, top = 10.dp, bottom = 10.dp, end = 8.dp),
            style = Typography.titleMedium
        )
    }
}

fun LightThemeColorCodeToHex(color: String): List<Color> {
    return when (color) {
        "g-13" -> listOf(
            Color(0xFFFE8C00),
            Color(0xFFF83600),
        )

        "g-12" -> listOf(
            Color(0xFF457FCA),
            Color(0xFF5691C8),
        )

        "g-11" -> listOf(
            Color(0xFF485563),
            Color(0xFF29323C),
        )

        else -> listOf(
            Color(0xFF457FCA),
            Color(0xFF5691C8),
        )
    }
}

fun DarkThemeColorCodeToHex(color: String): List<Color> {
    return when (color) {
        "g-13" -> listOf(
            Color(0xFFE4A501),
            Color(0xFFE03100),
        )

        "g-12" -> listOf(
            Color(0xFF254E83),
            Color(0xFF3A77B1),
        )

        "g-11" -> listOf(
            Color(0xFF15191E),
            Color(0xFF343F4C),
        )

        else -> listOf(
            Color(0xFF254E83),
            Color(0xFF3A77B1),
        )
    }
}

fun getIcon(icon: String): Int {
    return when (icon) {
        "rst-map_marker_path" -> R.drawable.map_marker_path_ic
        "rst-help" -> R.drawable.help_ic
        else -> R.drawable.default_weather_ic
    }
}

@Composable
fun ButtonItemShimmer() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val darkTheme = isSystemInDarkTheme()
        Box(
            modifier = Modifier
                .width(85.dp)
                .height(40.dp)
                .background(com.example.rst_test.presentaion.ui.theme.Color.OldPrice, shape = RoundedCornerShape(8.dp))
                .shimmerEffect(darkTheme)
        )
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
                .background(com.example.rst_test.presentaion.ui.theme.Color.OldPrice, shape = RoundedCornerShape(8.dp))
                .shimmerEffect(darkTheme)
        )

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
                .background(com.example.rst_test.presentaion.ui.theme.Color.OldPrice, shape = RoundedCornerShape(8.dp))
                .shimmerEffect(darkTheme)
        )
    }
}
package com.example.rst_test.presentaion.shared_components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

fun Modifier.shimmerEffect(
    isSystemInDarkTheme: Boolean,
    shape: Shape = DEFAULT_SHIMMER_SHAPE
): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(label = "")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(SHIMMER_ANIMATION_DURATION)
        ), label = ""
    )

    background(
        brush = Brush.linearGradient(
            colors = getShimmerColors(isSystemInDarkTheme),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        ),
        shape = shape
    )
        .onGloballyPositioned {
            size = it.size
        }
}

private fun getShimmerColors(isSystemInDarkTheme: Boolean) = when (isSystemInDarkTheme) {
    true -> listOf(
        Color.DarkGray,
        Color.Gray,
        Color.DarkGray
    )

    false -> listOf(
        Color(0xFFF3F3F3),
        Color(0xFFECECEC),
        Color(0xFFF3F3F3)
    )
}

private const val SHIMMER_ANIMATION_DURATION = 1000
private val DEFAULT_SHIMMER_SHAPE = RoundedCornerShape(8.dp)
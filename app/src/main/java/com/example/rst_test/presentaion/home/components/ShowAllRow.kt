package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rst_test.presentaion.shared_components.shimmerEffect
import com.example.rst_test.presentaion.ui.theme.Color
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun ShowAllRow(text: String, size: Int, action: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = text, style = Typography.headlineMedium)
        Text(
            modifier = Modifier
                .clickable {
                    action()
                },
            text = "Все ($size)",
            style = Typography.titleLarge,


            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun ShowAllRowShimmer() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(30.dp)
                .background(Color.OldPrice, shape = RoundedCornerShape(8.dp))
                .shimmerEffect(isSystemInDarkTheme())
        )
    }
}



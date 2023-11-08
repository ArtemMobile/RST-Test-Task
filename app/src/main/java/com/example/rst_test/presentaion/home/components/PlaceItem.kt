package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rst_test.domain.model.PlaceUiModel
import com.example.rst_test.presentaion.shared_components.LoadImageFromUrl
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun PlaceItem(place: PlaceUiModel, modifier: Modifier) {
    Column(modifier = modifier.fillMaxHeight()) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.Transparent
                ),
        ) {
            LoadImageFromUrl(
                url = place.image,
                modifier = Modifier.fillMaxWidth(),
                scale = ContentScale.Crop
            )
        }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = place.title,
                style = Typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = place.subtitle,
                maxLines = 1,
                style = Typography.bodySmall,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

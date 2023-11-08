package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rst_test.domain.model.BlogUiModel
import com.example.rst_test.presentaion.shared_components.LoadImageFromUrl
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun BlogItem(blog: BlogUiModel, modifier: Modifier) {
    Column(modifier = modifier.fillMaxHeight()) {
        Card(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.Transparent
                ).aspectRatio(1f),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        ) {
            LoadImageFromUrl(
                url = blog.image,
                modifier = Modifier.fillMaxSize(),
                scale = ContentScale.Crop
            )
        }
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = blog.date,
            style = Typography.headlineSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = blog.title,
            maxLines = 2,
            style = Typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
    }
}

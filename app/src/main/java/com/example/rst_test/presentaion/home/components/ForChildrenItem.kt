package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rst_test.domain.model.ChildUiModel
import com.example.rst_test.presentaion.shared_components.LoadImageFromUrl
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun ForChildrenItem(item: ChildUiModel) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)

    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(.33f)
                .aspectRatio(1f)
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.Transparent
                ),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        ) {
            LoadImageFromUrl(
                url = item.image,
                modifier = Modifier.fillMaxSize(),
                scale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.fillMaxHeight().padding(start = 8.dp)
        ) {

            Text(
                text = item.title,
                style = Typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = item.subtitle,
                style = Typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}
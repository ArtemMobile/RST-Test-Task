package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rst_test.domain.model.TourUiModel
import com.example.rst_test.presentaion.shared_components.LoadImageFromUrl
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun TourItem(item: TourUiModel) {
    Column(Modifier.padding(start = 16.dp, bottom = 16.dp)) {
        Card(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.Transparent
                ).aspectRatio(1.65f),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),

        ) {
            LoadImageFromUrl(
                url = item.image,
                modifier = Modifier.fillMaxWidth(),
                scale = ContentScale.FillBounds
            )
        }
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = item.title,
            style = Typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(verticalAlignment = Alignment.Bottom) {
            val priceOfRoom = item.price
            var priceTextColor = MaterialTheme.colorScheme.onBackground
            if (priceOfRoom.factPrice < priceOfRoom.price) {
                priceTextColor = MaterialTheme.colorScheme.scrim
                Text(
                    text = "${priceOfRoom.price}${priceOfRoom.currency}",
                    style = Typography.titleMedium.copy(
                        textDecoration = TextDecoration.LineThrough,
                        color = com.example.rst_test.presentaion.ui.theme.Color.OldPrice
                    )
                )
            }
            Text(
                text = "${priceOfRoom.factPrice}${priceOfRoom.currency}",
                style = Typography.titleMedium.copy(
                    color = priceTextColor
                )
            )
        }
        Text(
            text = item.duration,
            style = Typography.bodySmall
        )
    }
}

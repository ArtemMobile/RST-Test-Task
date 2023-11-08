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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.rst_test.domain.model.RoomUiModel
import com.example.rst_test.presentaion.shared_components.LoadImageFromUrl
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun RoomItem(item: RoomUiModel) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(start = 8.dp)

    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(.25f)
                .aspectRatio(1f)
                .padding(vertical = 8.dp, horizontal = 8.dp)
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
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 32.dp)
        ) {
            Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

            Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                Text(
                    text = item.countTourist,
                    style = Typography.titleMedium
                )
                Text(
                    text = item.title,
                    style = Typography.titleLarge
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
                                color = Color.Transparent
                            )
                        )
                    }
                    Text(
                        text = "${priceOfRoom.factPrice}${priceOfRoom.currency}",
                        style = Typography.titleMedium.copy(
                            color = priceTextColor
                        )
                    )
                    Text(
                        text = "/ ${item.duration}",
                        style = Typography.bodySmall.copy(
                            color = priceTextColor
                        )
                    )
                }
            }

        }

    }
}
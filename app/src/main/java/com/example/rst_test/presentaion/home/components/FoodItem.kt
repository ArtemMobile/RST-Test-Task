package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.rst_test.R
import com.example.rst_test.domain.model.FoodUiModel
import com.example.rst_test.presentaion.shared_components.LoadImageFromUrl
import com.example.rst_test.presentaion.shared_components.shimmerEffect
import com.example.rst_test.presentaion.ui.theme.Typography

@Composable
fun FoodItem(food: FoodUiModel) {
    Column(Modifier.padding(start = 16.dp, bottom = 16.dp)) {
        Card(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.Transparent
                )
                .aspectRatio(1.65f),
            border = BorderStroke(1.dp,MaterialTheme.colorScheme.outlineVariant),
        ) {
            LoadImageFromUrl(
                url = food.image,
                modifier = Modifier.fillMaxWidth(),
                scale = ContentScale.Crop
            )
        }
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = food.title,
            style = Typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = food.subtitle,
            maxLines = 2,
            style = Typography.bodySmall,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun FoodShimmerItem() {
    val darkTheme = isSystemInDarkTheme()
    Column(Modifier.padding(start = 16.dp, bottom = 16.dp)) {
        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.Transparent
                )
                .aspectRatio(1.65f)
                .shimmerEffect(darkTheme),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(id = R.drawable.placeholder),
                contentDescription = "",
                modifier = Modifier,
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth()
                .height(16.dp)
                .shimmerEffect(darkTheme)
        )
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth()
                .height(40.dp)
                .shimmerEffect(darkTheme)
        )
    }
}

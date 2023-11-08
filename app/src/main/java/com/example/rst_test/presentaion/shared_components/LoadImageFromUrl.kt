package com.example.rst_test.presentaion.shared_components

import android.graphics.Bitmap
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LoadImageFromUrl(url: String, modifier: Modifier, scale: ContentScale) {
    var image by remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(url) {
        val bitmap = withContext(Dispatchers.IO) {
            Picasso.get().load(url).get()
        }
        image = bitmap
    }

    image?.let {
        Image(bitmap = it.asImageBitmap(), contentDescription = null, modifier = modifier, contentScale = scale)
    }
}
package com.vk.education.homework2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.vk.education.homework2.network.ApiImage

@Composable
fun ImageCard(image: ApiImage, imageLoader: ImageLoader) {
    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(
                model = image.url,
                imageLoader = imageLoader,
            ),
            contentDescription = image.tags,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            image.tags
                .split(",")
                .map { it.trim() }
                .forEach { TagItem(it) }
        }

        Spacer(modifier = Modifier.height(4.dp))
    }
}
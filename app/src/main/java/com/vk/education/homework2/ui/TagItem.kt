package com.vk.education.homework2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.vk.education.homework2.R

@Composable
fun TagItem(tag: String) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .padding(vertical = 4.dp)
            .background(
                color = colorResource(R.color.tag_color),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp)
            .padding(vertical = 2.dp)
    ) {
        Text(
            text = "#$tag",
            color = Color.Black
        )
    }
}

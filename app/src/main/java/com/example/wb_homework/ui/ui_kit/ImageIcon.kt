package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ImageIcon(
    iconResId: Int,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center
) {
    Box(modifier = modifier, contentAlignment = contentAlignment) {
        AsyncImage(
            model = iconResId,
            contentDescription = "",
            contentScale = ContentScale.None
        )
    }
}

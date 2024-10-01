package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CardAvatar(
    modifier: Modifier,
    avatar: String,
) {
    AsyncImage(
        model = avatar,
        contentDescription = "",
        modifier = modifier
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AvatarForPerson(
    modifier: Modifier,
    avatar: String,
) {
    AsyncImage(
        model = avatar,
        contentDescription = "",
        modifier = modifier
            .clip(RoundedCornerShape(76.dp)),
        contentScale = ContentScale.Crop
    )
}
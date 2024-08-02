package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wb_homework.R

@Composable
fun AvatarProfileRegistration(
    modifier: Modifier = Modifier,
    avatar: Any?,
) {
    Box(contentAlignment = Alignment.BottomEnd) {
        if (avatar != null && avatar != "null") {
            AsyncImage(
                model = avatar,
                contentDescription = "",
                modifier = modifier,
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "",
                modifier = modifier,
            )
            ImageIcon(
                iconResId = R.drawable.add_avatar_icon,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun AvatarProfile(
    modifier: Modifier = Modifier,
    avatar: Any?,
) {
    Box(contentAlignment = Alignment.BottomEnd) {
        if (avatar != null && avatar != "null") {
            AsyncImage(
                model = avatar,
                contentDescription = "",
                modifier = modifier,
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "",
                modifier = modifier,
            )
        }
    }
}



package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.wb_homework.R

@Composable
fun AvatarBase(image: Int = R.drawable.avatar) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null
        )
    }
}

@Composable
fun AvatarForCard(image: String) {
    Box(
        modifier = Modifier.size(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberImagePainter(data = image),
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = "",
        )
    }

}
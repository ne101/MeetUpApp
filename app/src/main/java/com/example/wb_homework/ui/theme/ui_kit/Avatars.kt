package com.example.wb_homework.ui.theme.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
fun AvatarMeet(image: Int = R.drawable.meet) {
    Image(
        modifier = Modifier
            .size(48.dp)
            .padding(start = 4.dp, top = 4.dp),
        painter = painterResource(id = R.drawable.meet),
        contentDescription = "",
    )
}
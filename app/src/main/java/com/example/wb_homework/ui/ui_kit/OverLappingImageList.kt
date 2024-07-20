package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OverlappingImageList(images: List<String>, modifier: Modifier = Modifier) {
    Box(modifier = modifier.horizontalScroll(rememberScrollState())) {
        Row(horizontalArrangement = Arrangement.spacedBy((-8).dp)) {
            images.take(5).asReversed().forEach { image ->
                AvatarForCard(image)
            }
            if (images.size > 5) {
                Spacer(modifier = Modifier.width(24.dp))
                BodyText1(
                    text = "+${images.size - 5}",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}


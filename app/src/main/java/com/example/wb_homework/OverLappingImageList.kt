package com.example.wb_homework

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.theme.ui_kit.BodyText1

@Composable
fun OverlappingImageList(images: List<Int>, modifier: Modifier = Modifier) {
    Box(modifier = modifier.horizontalScroll(rememberScrollState())) {
        Row {
            images.take(5).forEachIndexed { index, image ->
                ImageForOverlappingList(image, index)
            }
            if (images.size > 5) {
                BodyText1(
                    text = "+${images.size - 5}",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun ImageForOverlappingList(imageId: Int, index: Int) {
    Image(
        painter = painterResource(id = imageId), contentDescription = "", modifier = Modifier
            .size(48.dp)
            .offset(x = ((-10).dp * index).coerceAtLeast((-40).dp))
    )
}

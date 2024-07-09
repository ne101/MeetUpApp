package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import coil.compose.rememberImagePainter

@Composable
fun MapImage(imageUrl: String) {
    var isDialogOpen by remember { mutableStateOf(false) }

    Image(
        painter = rememberImagePainter(data = imageUrl),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isDialogOpen = true }
    )

    if (isDialogOpen) {
        Dialog(onDismissRequest = { isDialogOpen = false }) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberImagePainter(data = imageUrl),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}


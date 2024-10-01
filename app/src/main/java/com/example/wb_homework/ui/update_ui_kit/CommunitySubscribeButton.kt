package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.ui.theme.BackGroundWhite
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.ui_kit.ImageIcon

@Composable
fun CommunitySubscribeButton(
    modifier: Modifier = Modifier,
    statusSubscribe: Boolean = false,
    onCLickListener: () -> Unit
) {
    val background = if (statusSubscribe) {
        PurpleWB
    } else {
        BackGroundWhite
    }

    val icon = if (statusSubscribe) {
        R.drawable.done_icon
    } else {
        R.drawable.plus_icon
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onCLickListener() }
            .background(background)
            .padding(8.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ImageIcon(iconResId = icon)
    }
}
package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.theme.BackGroundWhite
import com.example.wb_homework.ui.theme.PurpleWB

@Composable
fun ToggleButton(
    modifier: Modifier = Modifier,
    checkStatus: Boolean = true,
    onClickListener: () -> Unit,
) {
    val thumbOffset by animateFloatAsState(if (checkStatus) 48f - 20f - 2f else 2f, label = "")

    Box(
        modifier = modifier
            .size(width = 48.dp, height = 24.dp)
            .clip(RoundedCornerShape(68.dp))
            .background(if (checkStatus) PurpleWB else BackGroundWhite)
            .clickable { onClickListener() },
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .offset(x = thumbOffset.dp)
                .clip(RoundedCornerShape(68.dp))
                .background(Color.White),
        )
    }
}



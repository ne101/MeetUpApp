package com.example.wb_homework.ui.theme.ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wb_homework.domain.Event

@Composable
fun MyChips() {
    Row(modifier = Modifier.padding(16.dp)) {
        ChipView("Python")
        Spacer(modifier = Modifier.width(4.dp))
        ChipView("Junior")
        Spacer(modifier = Modifier.width(4.dp))
        ChipView("Moscow")
    }
}

@Composable
fun MyChipRow(event: Event) {
    Row {
        for (chip in event.chips) {
            ChipView(text = chip)
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

@Composable
fun ChipView(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(40.dp))
            .background(Color(0xFFF5ECFF))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        MetaData3(text = text, color = Color(0xFF660EC8))
    }
}
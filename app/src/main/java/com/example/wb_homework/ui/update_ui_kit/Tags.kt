package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.theme.BackGroundWhite
import com.example.wb_homework.ui.theme.PurpleDefault
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.BodyText2
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.ui.ui_kit.Subheading2

@Composable
fun TagSmall(
    modifier: Modifier = Modifier,
    category: String
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(BackGroundWhite)
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        TextSecondary(text = category, color = PurpleWB)

    }
}

@Composable
fun TagMedium(
    modifier: Modifier = Modifier,
    category: String,
    selectedTag: Boolean = false,
    enable: Boolean = true,
    onClickTag: () -> Unit
) {
    val backgroundColor = if (selectedTag) {
        PurpleWB
    } else {
        BackGroundWhite
    }
    val textColor = if (selectedTag) {
        Color.White
    } else {
        PurpleWB
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable(enabled = enable) {
                onClickTag()
            }
            .padding(8.dp)
    ) {
        TextForMediumTag(text = category, color = textColor)
    }
}

@Composable
fun TagBig(
    modifier: Modifier = Modifier,
    category: String,
    selectedTag: Boolean = false,
    onClickTag: () -> Unit
) {
    val backgroundColor = if (selectedTag) {
        PurpleWB
    } else {
        BackGroundWhite
    }
    val textColor = if (selectedTag) {
        Color.White
    } else {
        PurpleWB
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable {
                onClickTag()
            }
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        TextForBigTag(text = category, color = textColor)
    }

}


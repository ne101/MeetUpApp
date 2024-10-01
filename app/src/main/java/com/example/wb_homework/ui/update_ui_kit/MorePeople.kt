package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.ui.theme.BackGroundWhite
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.ui_kit.BodyText2

@Composable
fun MorePeople(
    modifier: Modifier = Modifier,
    countPeople: Int
) {
    Box(
        modifier = modifier
            .size(47.dp)
            .clip(RoundedCornerShape(76.dp))
            .background(BackGroundWhite),
        contentAlignment = Alignment.Center
    ) {
        BodyText2(
            text = stringResource(
                id = R.string.more_people,
                countPeople.toString()
            ),
            color = PurpleWB
        )
    }
}
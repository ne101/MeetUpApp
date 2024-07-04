package com.example.wb_homework.ui.theme.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.domain.AvatarState

@Composable
fun AvatarProfile(avatar: Int, modifier: Modifier = Modifier, state: AvatarState = AvatarState.Show) {

    Image(
        painter = if (state == AvatarState.Show) {
            painterResource(id = avatar)
        } else {
            painterResource(
                id = R.drawable.add_avatar
            )
        },
        contentDescription = "",
        modifier = modifier.size(200.dp)
    )
}


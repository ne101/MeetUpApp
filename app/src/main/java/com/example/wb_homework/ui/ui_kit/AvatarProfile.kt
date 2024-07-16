package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.wb_homework.R
import com.example.wb_homework.domain.entities.AvatarState

@Composable
fun AvatarProfile(
    modifier: Modifier = Modifier,
    avatar: Int,
    state: AvatarState = AvatarState.Show,
) {

    Image(
        painter = if (state == AvatarState.Show) {
            painterResource(id = avatar)
        } else {
            painterResource(
                id = R.drawable.add_avatar
            )
        },
        contentDescription = "",
        modifier = modifier
    )
}


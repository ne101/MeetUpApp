package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import com.example.domain.entities.AvatarState
import com.example.domain.entities.AvatarState.Show
import com.example.wb_homework.R

@Composable
fun AvatarProfile(
    modifier: Modifier = Modifier,
    avatar: String,
    state: AvatarState = Show,
) {

    Image(
        painter = if (state == Show) {
            rememberImagePainter(data = avatar)
        } else {
            painterResource(
                id = R.drawable.add_avatar
            )
        },
        contentDescription = "",
        modifier = modifier
    )

}

@Composable
fun AvatarProfile(
    modifier: Modifier = Modifier,
    avatar: Int,
    state: AvatarState = Show,
) {

    Image(
        painter = if (state == Show) {
            rememberImagePainter(data = avatar)
        } else {
            painterResource(
                id = R.drawable.add_avatar
            )
        },
        contentDescription = "",
        modifier = modifier
    )

}


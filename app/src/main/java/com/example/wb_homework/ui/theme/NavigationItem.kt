package com.example.wb_homework.ui.theme

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wb_homework.R
import com.example.wb_homework.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val image: Int
) {
   data object Meet : NavigationItem(
        screen = Screen.Meet,
        titleResId = R.string.meet,
        image = R.drawable.meet_icon

    )

    data object Community : NavigationItem(
        screen = Screen.Community,
        titleResId = R.string.Community,
        image = R.drawable.community_icon

    )

    data object More : NavigationItem(
        screen = Screen.More,
        titleResId = R.string.more,
        image = R.drawable.more_icon

    )

}

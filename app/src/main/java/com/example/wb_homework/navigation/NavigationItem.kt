package com.example.wb_homework.navigation

import com.example.wb_homework.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val image: Int
) {
   data object Meet : NavigationItem(
        screen = Screen.EventScreen,
        titleResId = R.string.meet,
        image = R.drawable.meet_icon

    )

    data object Community : NavigationItem(
        screen = Screen.CommunityScreen,
        titleResId = R.string.Community,
        image = R.drawable.community_icon

    )

    data object More : NavigationItem(
        screen = Screen.MoreScreen,
        titleResId = R.string.more,
        image = R.drawable.more_icon

    )

}


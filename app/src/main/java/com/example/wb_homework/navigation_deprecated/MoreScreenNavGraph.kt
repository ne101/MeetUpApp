package com.example.wb_homework.navigation_deprecated

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.moreScreenNavGraph(
    moreScreenContent: @Composable () -> Unit,
    myEventsScreenContent: @Composable () -> Unit,
    profileEventScreenContent: @Composable () -> Unit,
    detailEventFromMoreScreenContent: @Composable (Int) -> Unit,
    themeScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.More.route,
        route = Screen.MoreScreen.route
    ) {
        composable(Screen.More.route) {
            moreScreenContent()
        }

        composable(Screen.Profile.route) {
            profileEventScreenContent()
        }

        composable(Screen.MyEvents.route) {
            myEventsScreenContent()
        }

        composable(Screen.DetailEventFromMoreScreen.route) {
            val eventId = it.arguments?.getString(Screen.DetailEventFromMoreScreen.KEY_ID) ?: ""
            detailEventFromMoreScreenContent(eventId.toInt())
        }

        composable(Screen.Theme.route) {
            themeScreenContent()
        }
    }
}
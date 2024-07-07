package com.example.wb_homework.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.eventScreenNavGraph(
    eventsScreenContent: @Composable () -> Unit,
    detailEventFromEventScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = Screen.Events.route,
        route = Screen.EventScreen.route
    ) {
        composable(Screen.Events.route) {
            eventsScreenContent()
        }

        composable(Screen.DetailEventFromEventScreen.route) {
            detailEventFromEventScreenContent()
        }
    }
}
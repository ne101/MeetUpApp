package com.example.wb_homework.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.communityScreenNavGraph(
    communityScreenContent: @Composable () -> Unit,
    detailEventFromCommunityScreenContent: @Composable () -> Unit,
    detailCommunityScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = Screen.Community.route,
        route = Screen.CommunityScreen.route
    ) {
        composable(Screen.Community.route) {
            communityScreenContent()
        }
        composable(Screen.DetailCommunity.route) {
            detailCommunityScreenContent()
        }
        composable(Screen.DetailEventFromCommunityScreen.route) {
            detailEventFromCommunityScreenContent()
        }
    }
}
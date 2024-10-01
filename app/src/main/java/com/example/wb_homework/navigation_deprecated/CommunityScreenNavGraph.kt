package com.example.wb_homework.navigation_deprecated

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.communityScreenNavGraph(
    communityScreenContent: @Composable () -> Unit,
    detailEventFromCommunityScreenContent: @Composable (Int) -> Unit,
    detailCommunityScreenContent: @Composable (Int) -> Unit
) {
    navigation(
        startDestination = Screen.Community.route,
        route = Screen.CommunityScreen.route,
    ) {
        composable(Screen.Community.route) {
            communityScreenContent()
        }
        composable(Screen.DetailCommunity.route) {
            val communityId = it.arguments?.getString(Screen.DetailCommunity.KEY_ID) ?: ""
            detailCommunityScreenContent(communityId.toInt())
        }
        composable(Screen.DetailEventFromCommunityScreen.route) {
            val eventId = it.arguments?.getString(
                Screen.DetailEventFromCommunityScreen.KEY_ID
            ) ?: ""
            detailEventFromCommunityScreenContent(eventId.toInt())
        }
    }
}
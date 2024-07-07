package com.example.wb_homework.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    eventsScreenContent: @Composable () -> Unit,
    detailEventFromCommunityScreenContent: @Composable () -> Unit,
    detailEventFromEventScreenContent: @Composable () -> Unit,
    communityScreenContent: @Composable () -> Unit,
    detailCommunityScreenContent: @Composable () -> Unit,
    moreScreenContent: @Composable () -> Unit,
    myEventsScreenContent: @Composable () -> Unit,
    profileEventScreenContent: @Composable () -> Unit,
    detailEventFromMoreScreenContent: @Composable () -> Unit

) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.EventScreen.route
    ) {
        eventScreenNavGraph(
            eventsScreenContent = eventsScreenContent,
            detailEventFromEventScreenContent = detailEventFromEventScreenContent
        )

        communityScreenNavGraph(
            communityScreenContent = communityScreenContent,
            detailCommunityScreenContent = detailCommunityScreenContent,
            detailEventFromCommunityScreenContent = detailEventFromCommunityScreenContent
        )

        moreScreenNavGraph(
            moreScreenContent = moreScreenContent,
            profileEventScreenContent = profileEventScreenContent,
            myEventsScreenContent = myEventsScreenContent,
            detailEventFromMoreScreenContent = detailEventFromMoreScreenContent
        )
    }
}
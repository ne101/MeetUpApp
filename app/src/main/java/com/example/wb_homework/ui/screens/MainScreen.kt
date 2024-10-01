package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wb_homework.navigation.AppNavGraph
import com.example.wb_homework.navigation.Screen
import com.example.wb_homework.navigation.rememberNavigationState


@Composable
internal fun MainScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            mainPageScreenContent = {
                MainPageScreen(
                    modifier = Modifier.padding(paddingValues),
                    onEventClickListener = { eventId, communityId ->
                        navigationState.navigateTo(Screen.Event(eventId, communityId))
                    },
                    onCommunityClickListener = { communityId ->
                        navigationState.navigateTo(Screen.Community(communityId))
                    },
                    onProfileClickListener = {
                        navigationState.navigateTo(Screen.Profile)
                    }
                )
            },
            eventScreenContent = { eventId, communityId ->
                EventScreen(
                    eventId,
                    communityId,
                    onEventClickListener = { newEventId, newCommunityId ->
                        navigationState.navigateTo(Screen.Event(newEventId, newCommunityId))
                    },
                    onCommunityClickListener = { id ->
                        navigationState.navigateTo(Screen.Community(id))
                    },
                    onBackClickListener = {
                        navigationState.navHostController.navigateUp()
                    },
                    onPersonClickListener = { title ->
                        navigationState.navigateTo(Screen.Persons(eventId, title))
                    }
                )
            },
            communityScreenContent = { communityId ->
                CommunityScreen(
                    communityId = communityId,
                    onEventClickListener = { newEventId, newCommunityId ->
                        navigationState.navigateTo(Screen.Event(newEventId, newCommunityId))
                    },
                    onBackClickListener = {
                        navigationState.navHostController.navigateUp()
                    }
                )
            },
            onPersonsScreenContent = { eventId, title ->
                PeopleScreen(
                    eventId = eventId,
                    title = title,
                    onBackClickListener = {
                        navigationState.navHostController.navigateUp()
                    }
                )
            },
            onInterestsScreenContent = {
                InterestsScreen(
                    onLaunchMainScreenClickListener = {
                        navigationState.navigateTo(Screen.MainPage)
                    }
                )
            },
            onProfileScreenContent = {
                ProfileScreen(
                    onEventClickListener = { eventId, communityId ->
                        navigationState.navigateTo(Screen.Event(eventId, communityId))
                    },
                    onCommunityClickListener = {
                        navigationState.navigateTo(Screen.Community(it))
                    },
                    onBackClickListener = {
                        navigationState.navHostController.navigateUp()
                    },
                )
            }
        )
    }
}
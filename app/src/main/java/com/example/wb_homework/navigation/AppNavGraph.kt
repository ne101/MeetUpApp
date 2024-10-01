package com.example.wb_homework.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    mainPageScreenContent: @Composable () -> Unit,
    eventScreenContent: @Composable (Int, Int) -> Unit,
    communityScreenContent: @Composable (Int) -> Unit,
    onPersonsScreenContent: @Composable (Int, String) -> Unit,
    onInterestsScreenContent: @Composable () -> Unit,
    onProfileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Interests,
        enterTransition = {
            fadeIn(animationSpec = tween(400))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(400))
        },
        popExitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None }

    ) {
        composable<Screen.MainPage> {
            mainPageScreenContent()
        }
        composable<Screen.Event> {
            val args = it.toRoute<Screen.Event>()
            eventScreenContent(args.eventId, args.communityId)
        }
        composable<Screen.Community> {
            val args = it.toRoute<Screen.Community>()
            communityScreenContent(args.communityId)
        }

        composable<Screen.Persons> {
            val args = it.toRoute<Screen.Persons>()
            onPersonsScreenContent(args.eventId, args.title)
        }
        composable<Screen.Interests> {
            onInterestsScreenContent()
        }
        composable<Screen.Profile> {
            onProfileScreenContent()
        }
    }
}
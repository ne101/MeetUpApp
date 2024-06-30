package com.example.wb_homework.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    meetScreenContent: @Composable () -> Unit,
    communityScreenContent: @Composable () -> Unit,
    moreScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ROUTE_MEET
    ) {
        composable(Screen.ROUTE_MEET) {
            meetScreenContent()
        }

        composable(Screen.ROUTE_COMMUNITY) {
            communityScreenContent()
        }

        composable(Screen.ROUTE_MORE) {
            moreScreenContent()
        }

    }
}
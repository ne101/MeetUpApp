package com.example.wb_homework.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController,
) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToAuthCodeScreen(phoneNumber: String) {
        navHostController.navigate(Screen.AuthCode.getRouteWithArgs(phoneNumber))
    }
    fun navigateToCreateAccountScreen(phoneNumber: String) {
        navHostController.navigate(Screen.CreateAccount.getRouteWithArgs(phoneNumber))
    }
    fun navigateToDetailCommunityScreen(communityId: Int) {
        navHostController.navigate(Screen.DetailCommunity.getRouteWithArgs(communityId))
    }
    fun navigateToDetailEventScreenFromEventScreen(eventId: Int) {
        navHostController.navigate(Screen.DetailEventFromEventScreen.getRouteWithArgs(eventId))
    }
    fun navigateToDetailEventScreenFromCommunityScreen(eventId: Int) {
        navHostController.navigate(Screen.DetailEventFromCommunityScreen.getRouteWithArgs(eventId))
    }
    fun navigateToDetailEventScreenFromMoreScreen(eventId: Int) {
        navHostController.navigate(Screen.DetailEventFromMoreScreen.getRouteWithArgs(eventId))
    }

}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState = remember {
    NavigationState(navHostController)
}
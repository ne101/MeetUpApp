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
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState = remember {
    NavigationState(navHostController)
}
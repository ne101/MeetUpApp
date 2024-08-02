package com.example.wb_homework.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    eventsScreenContent: @Composable () -> Unit,
    detailEventFromCommunityScreenContent: @Composable (Int) -> Unit,
    detailEventFromEventScreenContent: @Composable (Int) -> Unit,
    communityScreenContent: @Composable () -> Unit,
    detailCommunityScreenContent: @Composable (Int) -> Unit,
    moreScreenContent: @Composable () -> Unit,
    myEventsScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    detailEventFromMoreScreenContent: @Composable (Int) -> Unit,
    themeScreenContent: @Composable () -> Unit,
    authPhoneScreenContent: @Composable () -> Unit,
    authCodeScreenContent: @Composable (String) -> Unit,
    createAccountScreenContent: @Composable (String) -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.AuthPhone.route,
        enterTransition = {
            fadeIn(animationSpec = tween(400))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(200))
        },
        ) {
        composable(Screen.AuthPhone.route) {
            authPhoneScreenContent()
        }
        composable(Screen.AuthCode.route) {
            val phoneNumber = it.arguments?.getString(Screen.AuthCode.KEY_PHONE_NUMBER) ?: ""
            authCodeScreenContent(phoneNumber)
        }
        composable(Screen.CreateAccount.route) {
            val phoneNumber = it.arguments?.getString(Screen.CreateAccount.KEY_PHONE_NUMBER) ?: ""
            createAccountScreenContent(phoneNumber)
        }
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
            profileEventScreenContent = profileScreenContent,
            myEventsScreenContent = myEventsScreenContent,
            detailEventFromMoreScreenContent = detailEventFromMoreScreenContent,
            themeScreenContent = themeScreenContent
        )
    }
}
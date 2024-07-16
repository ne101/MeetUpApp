package com.example.wb_homework.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
    detailEventFromMoreScreenContent: @Composable () -> Unit,
    themeScreenContent: @Composable () -> Unit,
    authPhoneScreenContent: @Composable () -> Unit,
    authCodeScreenContent: @Composable (String) -> Unit,
    createAccountScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.AuthPhone.route
    ) {
        composable(Screen.AuthPhone.route) {
            authPhoneScreenContent()
        }
        composable(Screen.AuthCode.route) {
            val phoneNumber = it.arguments?.getString(Screen.AuthCode.KEY_PHONE_NUMBER) ?: ""
            authCodeScreenContent(phoneNumber)
        }
        composable(Screen.CreateAccount.route) {
            createAccountScreenContent()
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
            profileEventScreenContent = profileEventScreenContent,
            myEventsScreenContent = myEventsScreenContent,
            detailEventFromMoreScreenContent = detailEventFromMoreScreenContent,
            themeScreenContent = themeScreenContent
        )
    }
}
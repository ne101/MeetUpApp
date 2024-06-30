package com.example.wb_homework.navigation

sealed class Screen(val route: String) {
    data object Meet : Screen(ROUTE_MEET)
    data object Community : Screen(ROUTE_COMMUNITY)
    data object More : Screen(ROUTE_MORE)

    companion object {
        const val ROUTE_MEET = "meet"
        const val ROUTE_COMMUNITY = "community"
        const val ROUTE_MORE = "more"
    }
}
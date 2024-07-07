package com.example.wb_homework.navigation

sealed class Screen(val route: String) {

    data object EventScreen : Screen(EVENT_SCREEN)
    data object CommunityScreen : Screen(COMMUNITY_SCREEN)
    data object MoreScreen : Screen(MORE_SCREEN)
    data object Events : Screen(ROUTE_EVENTS)
    data object DetailEventFromEventScreen : Screen(ROUTE_DETAIL_EVENT_FROM_EVENT_SCREEN)
    data object DetailEventFromCommunityScreen : Screen(ROUTE_DETAIL_EVENT_FROM_COMMUNITY_SCREEN)
    data object DetailEventFromMoreScreen : Screen(ROUTE_DETAIL_EVENT_FROM_MORE_SCREEN)
    data object Community : Screen(ROUTE_COMMUNITY)
    data object DetailCommunity : Screen(ROUTE_DETAIL_COMMUNITY)
    data object More : Screen(ROUTE_MORE)
    data object Profile : Screen(ROUTE_PROFILE)
    data object MyEvents : Screen(ROUTE_MY_EVENTS)

    private companion object {
        const val EVENT_SCREEN = "event_screen"
        const val COMMUNITY_SCREEN = "community_screen"
        const val MORE_SCREEN = "more_screen"
        const val ROUTE_EVENTS = "events"
        const val ROUTE_DETAIL_EVENT_FROM_COMMUNITY_SCREEN = "detail_event_from_community_screen"
        const val ROUTE_DETAIL_EVENT_FROM_EVENT_SCREEN = "detail_event_from_event_screen"
        const val ROUTE_DETAIL_EVENT_FROM_MORE_SCREEN = "detail_event_from_more_screen"
        const val ROUTE_DETAIL_COMMUNITY = "detail_community"
        const val ROUTE_COMMUNITY = "community"
        const val ROUTE_MORE = "more"
        const val ROUTE_PROFILE = "profile"
        const val ROUTE_MY_EVENTS = "my_events"
    }
}
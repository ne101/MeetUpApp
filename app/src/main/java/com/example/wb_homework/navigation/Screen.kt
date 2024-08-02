package com.example.wb_homework.navigation

sealed class Screen(val route: String) {

    data object EventScreen : Screen(EVENT_SCREEN)
    data object CommunityScreen : Screen(COMMUNITY_SCREEN)
    data object MoreScreen : Screen(MORE_SCREEN)
    data object Events : Screen(ROUTE_EVENTS)

    data object DetailEventFromEventScreen : Screen(ROUTE_DETAIL_EVENT_FROM_EVENT_SCREEN) {
        private const val ROUTE_FOR_ARGS = "detail_event_from_event_screen"
        const val KEY_ID = "id"
        fun getRouteWithArgs(id: Int): String {
            return "$ROUTE_FOR_ARGS/${id}"
        }
    }

    data object DetailEventFromCommunityScreen : Screen(ROUTE_DETAIL_EVENT_FROM_COMMUNITY_SCREEN) {
        private const val ROUTE_FOR_ARGS = "detail_event_from_community_screen"
        const val KEY_ID = "id"
        fun getRouteWithArgs(id: Int): String {
            return "$ROUTE_FOR_ARGS/${id}"
        }
    }

    data object DetailEventFromMoreScreen : Screen(ROUTE_DETAIL_EVENT_FROM_MORE_SCREEN) {
        private const val ROUTE_FOR_ARGS = "detail_event_from_more_screen"
        const val KEY_ID = "id"
        fun getRouteWithArgs(id: Int): String {
            return "$ROUTE_FOR_ARGS/${id}"
        }
    }

    data object Community : Screen(ROUTE_COMMUNITY)

    data object DetailCommunity : Screen(ROUTE_DETAIL_COMMUNITY) {
        private const val ROUTE_FOR_ARGS = "detail_community"
        const val KEY_ID = "id"
        fun getRouteWithArgs(id: Int): String {
            return "$ROUTE_FOR_ARGS/${id}"
        }
    }

    data object More : Screen(ROUTE_MORE)
    data object Profile : Screen(ROUTE_PROFILE)
    data object MyEvents : Screen(ROUTE_MY_EVENTS)
    data object Theme : Screen(ROUTE_THEME)
    data object AuthPhone : Screen(ROUTE_AUTH_PHONE)

    data object AuthCode : Screen(ROUTE_AUTH_CODE) {
        private const val ROUTE_FOR_ARGS = "auth_code"
        const val KEY_PHONE_NUMBER = "phone_number"
        fun getRouteWithArgs(phoneNumber: String): String {
            return "$ROUTE_FOR_ARGS/${phoneNumber}"
        }
    }

    data object CreateAccount : Screen(ROUTE_CREATE_ACCOUNT) {
        private const val ROUTE_FOR_ARGS = "create_account"
        const val KEY_PHONE_NUMBER = "phone_number"
        fun getRouteWithArgs(phoneNumber: String): String {
            return "$ROUTE_FOR_ARGS/${phoneNumber}"
        }
    }

    private companion object {

        const val EVENT_SCREEN = "event_screen"
        const val COMMUNITY_SCREEN = "community_screen"
        const val MORE_SCREEN = "more_screen"
        const val ROUTE_EVENTS = "events"
        const val ROUTE_DETAIL_EVENT_FROM_COMMUNITY_SCREEN =
            "detail_event_from_community_screen/{${DetailEventFromCommunityScreen.KEY_ID}}"
        const val ROUTE_DETAIL_EVENT_FROM_EVENT_SCREEN =
            "detail_event_from_event_screen/{${DetailEventFromEventScreen.KEY_ID}}"
        const val ROUTE_DETAIL_EVENT_FROM_MORE_SCREEN =
            "detail_event_from_more_screen/{${DetailEventFromMoreScreen.KEY_ID}}"
        const val ROUTE_DETAIL_COMMUNITY = "detail_community/{${DetailCommunity.KEY_ID}}"
        const val ROUTE_COMMUNITY = "community"
        const val ROUTE_MORE = "more"
        const val ROUTE_PROFILE = "profile"
        const val ROUTE_MY_EVENTS = "my_events"
        const val ROUTE_THEME = "theme"
        const val ROUTE_AUTH_PHONE = "auth_phone"
        const val ROUTE_AUTH_CODE = "auth_code/{${AuthCode.KEY_PHONE_NUMBER}}"
        const val ROUTE_CREATE_ACCOUNT = "create_account/{${CreateAccount.KEY_PHONE_NUMBER}}"

    }
}
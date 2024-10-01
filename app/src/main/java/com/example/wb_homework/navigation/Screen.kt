package com.example.wb_homework.navigation

import kotlinx.serialization.Serializable

sealed class Screen
{
    @Serializable
    data object MainPage : Screen()
    @Serializable
    data class Event(val eventId: Int, val communityId: Int) : Screen()
    @Serializable
    data class Community(val communityId: Int) : Screen()
    @Serializable
    data class Persons(val eventId: Int, val title: String) : Screen()
    @Serializable
    data object Interests : Screen()
    @Serializable
    data object Profile : Screen()
}
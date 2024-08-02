package com.example.domain.entities

data class Profile(
    val name: String = "",
    val secondName: String = "",
    val phone: String = "",
    val avatar: Any?,
    val events: List<Event> = emptyList(),
)
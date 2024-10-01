package com.example.domain.entities

data class Profile(
    val name: String = "",
    val city: String = "",
    val secondName: String = "",
    val phone: String = "",
    val avatar: String = "",
    val events: List<Event> = emptyList(),
    val communities: List<Community> = emptyList(),
    val tags: Tags = Tags(emptyList()),
    val description: String = "",
    val habrName: String = "",
    val telegramName: String = "",
    val showEvents: Boolean = true,
    val showCommunities: Boolean = true
)
package com.example.domain.entities

import com.example.domain.entities.Community.Companion.IMAGE_URL

data class Person(
    val id: Int = 0,
    val avatar: String = IMAGE_URL,
    val name: String = "Человек",
    val tags: List<String> = listOf("Python", "Junior", "Moscow")
)

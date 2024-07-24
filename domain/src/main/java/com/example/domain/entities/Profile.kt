package com.example.domain.entities

import com.example.domain.entities.Community.Companion.IMAGE_URL
import kotlin.random.Random

data class Profile(
    val name: String = "Иван Иванов",
    val phone: String = "+7 999 999-99-99",
    val avatar: String = IMAGE_URL,
    val events: List<Event> = mutableListOf<Event>().apply {
        repeat(40) {
            add(Event(id = it, finished = Random.nextBoolean()))
        }
    }
)
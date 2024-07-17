package com.example.wb_homework.domain.entities

import com.example.wb_homework.R
import kotlin.random.Random

data class Profile(
    val name: String = "Иван Иванов",
    val phone: String = "+7 999 999-99-99",
    val avatarResId: Int = R.drawable.avatar,
    val events: List<Event> = mutableListOf<Event>().apply {
        repeat(40) {
            add(Event(id = it, finished = Random.nextBoolean()))
        }
    }
)
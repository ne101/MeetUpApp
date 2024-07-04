package com.example.wb_homework.domain

import com.example.wb_homework.R

data class Event(
    val eventName: String = "Developer meeting",
    val data: String = "13.09.2024",
    val city: String = "Москва",
    val avatarId: Int = R.drawable.meet,
    val chips: List<String> = listOf("Python", "Junior", "Moscow"),
)

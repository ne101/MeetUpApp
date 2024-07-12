package com.example.wb_homework.domain

import android.content.IntentSender.OnFinished
import com.example.wb_homework.R

data class Event(
    val id: Int = 0,
    val eventName: String = "Developer meeting",
    val data: String = "13.09.2024",
    val city: String = "Москва",
    val street: String = "ул.Громова, 4",
    val avatarId: Int = R.drawable.meet,
    val chips: List<String> = listOf("Python", "Junior", "Moscow"),
    val finished: Boolean = false
)

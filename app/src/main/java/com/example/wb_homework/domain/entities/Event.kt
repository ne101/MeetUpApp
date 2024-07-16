package com.example.wb_homework.domain.entities

import com.example.wb_homework.R

data class Event(
    val id: Int = 0,
    val eventName: String = "Developer meeting",
    val data: String = "13.09.2024",
    val city: String = "Москва",
    val street: String = "ул.Громова, 4",
    val avatarId: Int = R.drawable.meet,
    val chips: List<String> = listOf("Python", "Junior", "Moscow"),
    val finished: Boolean = false,
    val imageList: List<Int> = mutableListOf<Int>().apply {
        repeat(20) {
            add(R.drawable.person_on_meet)
        }
    },
    val mapUrl: String =
        "https://gas-kvas.com/grafic/uploads/posts/2024-01/gas-kvas-com-p-karta-mira-na-prozrachnom-fone-dlya-detei-3.jpg"
)


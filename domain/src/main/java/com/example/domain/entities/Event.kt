package com.example.domain.entities

import com.example.domain.entities.Community.Companion.IMAGE_URL


data class Event(
    val id: Int = 0,
    val eventName: String = "Developer meeting",
    val data: String = "13.09.2024",
    val city: String = "Москва",
    val street: String = "ул.Громова, 4",
    val avatar: String = IMAGE_URL,
    val chips: List<String> = listOf("Python", "Junior", "Moscow"),
    val finished: Boolean = false,
    val imageList: List<String> = mutableListOf<String>().apply {
        repeat(20) {
            add(IMAGE_URL)
        }
    },
    val mapUrl: String =
        "https://gas-kvas.com/grafic/uploads/posts/2024-01/gas-kvas-com-p-karta-mira-na-prozrachnom-fone-dlya-detei-3.jpg",
)


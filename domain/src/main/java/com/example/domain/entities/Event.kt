package com.example.domain.entities

import com.example.domain.entities.Community.Companion.IMAGE_URL


data class Event(
    val id: Int = 0,
    val eventName: String = "Developer meeting",
    val date: String = "13.09.2024",
    val eventHostName: String = "Павел Воля",
    val descriptionByHost: String = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
    val description: String = "Информация о мероприятии",
    val city: String = "Москва",
    val street: String = "ул.Громова, 4",
    val avatar: String = IMAGE_URL,
    val avatarHost: String = IMAGE_URL,
    val tags: List<String> = listOf("Тестирование", "Разработка", "Mobile"),
    val numberOfSeats: Int = 30,
    val finished: Boolean = false,
    val personList: List<Person> = mutableListOf<Person>().apply {
        repeat(20) {
            add(Person(id = it))
        }
    },
    val communityId: Int = 0,
    val mapUrl: String =
        "https://gas-kvas.com/grafic/uploads/posts/2024-01/gas-kvas-com-p-karta-mira-na-prozrachnom-fone-dlya-detei-3.jpg",
)


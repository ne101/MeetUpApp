package com.example.domain.entities

import kotlin.random.Random

data class Community(
    val communityName: String = "Designa",
    val countSubscribers: String = "10000 человек",
    val avatarCommunity: String = IMAGE_URL,
    val id: Int = 0,
    val events: List<Event> = generationEvent,
    val description: String = "Информация о сообществе"

) {
    companion object {
        val generationEvent = mutableListOf<Event>().apply {
            repeat(40) {
                add(Event(id = it, finished = Random.nextBoolean()))
            }
        }
        const val IMAGE_URL = "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/square-logo-social-media-template-design-3c67549ba9a7c8c66b762920347c7939_screen.jpg?ts=1589204086"
    }
}

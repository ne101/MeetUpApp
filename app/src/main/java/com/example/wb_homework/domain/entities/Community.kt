package com.example.wb_homework.domain.entities

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.wb_homework.R
import kotlin.random.Random

data class Community(
    val communityName: String = "Designa",
    val countSubscribers: String = "10000 человек",
    val avatarCommunityId: Int = R.drawable.avatar_community,
    val id: Int = 0,
    val events: List<Event> = communityEvents,
    val description: String = LoremIpsum().values.first().take(50)
) {
    private companion object {
        val communityEvents = mutableListOf<Event>().apply {
            repeat(40) {
                add(Event(id = it, finished = Random.nextBoolean()))
            }
        }
    }
}

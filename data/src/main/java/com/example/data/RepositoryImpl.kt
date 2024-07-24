package com.example.data


import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile
import com.example.domain.repository.Repository
import kotlin.random.Random

class RepositoryImpl : Repository {
    override fun getEvent(): Event {
        return Event()
    }

    override fun getEventList(): List<Event> {
        return mutableListOf<Event>().apply {
            repeat(40) {
                add(
                    Event(
                        id = it,
                        finished = Random.nextBoolean(),
                    )
                )
            }
        }
    }

    override fun getCommunity(): Community {
        return Community()
    }

    override fun getCommunityList(): List<Community> {
        return mutableListOf<Community>().apply {
            repeat(40) {
                add(Community(id = it))
            }
        }
    }

    override fun getProfile(): Profile {
        return Profile()
    }
}
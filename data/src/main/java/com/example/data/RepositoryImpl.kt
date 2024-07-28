package com.example.data


import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile
import com.example.domain.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlin.random.Random

class RepositoryImpl : Repository {
    private val eventList = mutableListOf<Event>().apply {
        repeat(40) {
            add(
                Event(
                    id = it,
                    finished = Random.nextBoolean(),
                )
            )
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getPlannedEventList(): Flow<List<Event>> {
        return getEventList().mapLatest {
            it.filter { event ->
                !event.finished
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getPassedEventList(): Flow<List<Event>> {
        return getEventList().mapLatest {
            it.filter { event ->
                event.finished
            }
        }
    }

    override fun getEvent() = flow {
        emit(Event())
    }

    override fun getEventList(): Flow<List<Event>> {
        return flow {
            emit(eventList)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getActiveEventList(): Flow<List<Event>> {
        return getEventList().mapLatest {
            it.filter { event ->
                !event.finished
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getAllEventList(): Flow<List<Event>> {
        return getEventList().mapLatest {
            it
        }
    }

    override fun getCommunity() = flow {
        emit(Community())
    }

    override fun getCommunityList() = flow {
        val communityList = mutableListOf<Community>().apply {
            repeat(40) {
                add(Community(id = it))
            }
        }
        emit(communityList)
    }

    override fun getProfile() = flow {
        emit(Profile())
    }
}
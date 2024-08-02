package com.example.data.repository_impl


import com.example.data.local_data_base.ProfileDao
import com.example.data.mapper.Mapper
import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.random.Random

internal class RepositoryImpl(
    private val mapper: Mapper,
    private val profileDao: ProfileDao,
) : Repository {

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

    private val communityList = mutableListOf<Community>().apply {
        repeat(40) {
            add(Community(id = it))
        }
    }

    override suspend fun saveProfile(profile: Profile) {
        profileDao.saveProfile(mapper.mapProfileToProfileTable(profile))
    }

    override suspend fun deleteProfile(id: Int) {
        profileDao.deleteProfile(id)
    }

    override fun getMyEvent(id: Int): Flow<Event> =
        profileDao.getMyEvent(id).map { event ->
            mapper.mapEventTableToEvent(event)
        }


    override fun getMyEventList(): Flow<List<Event>> =
        profileDao.getMyEventList().map { eventList ->
            eventList.map { event ->
                mapper.mapEventTableToEvent(event)
            }
        }

    override suspend fun addMyEvent(event: Event) {
        profileDao.addMyEvent(mapper.mapEventToEventTable(event))
    }

    override suspend fun deleteMyEvent(id: Int) {
        profileDao.deleteMyEvent(id)
    }

    override fun getPlannedEventList() = getMyEventList().map {
        it.filter { event ->
            !event.finished
        }
    }

    override fun getPassedEventList() = getMyEventList().map {
        it.filter { event ->
            event.finished
        }
    }

    override fun getEvent(id: Int) = flow {
        emit(eventList[id])
    }

    override fun getEventList() = flow {
        emit(eventList)
    }

    override fun getActiveEventList() = getEventList().map {
        it.filter { event ->
            !event.finished
        }
    }

    override fun getAllEventList() = getEventList().map {
        it
    }

    override fun getCommunity(id: Int) = flow {
        emit(communityList[id])
    }

    override fun getCommunityList() = flow {
        emit(communityList)
    }

    override fun getProfile(id: Int): Flow<Profile> =
        profileDao.getProfile(id).map { profile ->
            mapper.mapProfileTableToProfile(profile)
        }
}
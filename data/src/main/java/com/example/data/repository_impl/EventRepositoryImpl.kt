package com.example.data.repository_impl

import com.example.data.local_data_base.dao.EventDao
import com.example.data.local_data_base.mock.MockData
import com.example.data.mapper.Mapper
import com.example.domain.entities.Event
import com.example.domain.entities.Tags
import com.example.domain.repository.EventRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class EventRepositoryImpl(
    private val eventDao: EventDao,
    private val mockData: MockData,
    private val mapper: Mapper
) : EventRepository {


    private val eventFlow = MutableSharedFlow<Event>(replay = 1)
    private val eventListFlow = MutableSharedFlow<List<Event>>(replay = 1)
    private val tagsFlow = MutableStateFlow<List<String>>(emptyList())

    override fun getEvent() = eventFlow.asSharedFlow()

    override suspend fun fetchEvent(id: Int) {
       val event = mockData.eventList[id]
        eventFlow.emit(event)
    }

    override suspend fun fetchEventList() {
        val events = mockData.eventList
        eventListFlow.emit(events)
    }

    override fun getActiveEventList() = eventListFlow.map { eventList ->
        eventList.filterNot { event ->
            event.finished
        }
    }

    override fun getAllEventList() = eventListFlow.asSharedFlow()

    override fun getPlannedEventList(): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override fun getPassedEventList(): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllEvents() = eventDao.deleteAllEvents()

    override fun getMyEvent(id: Int) = eventDao.getMyEvent(id).map {
        mapper.mapEventTableToEvent(it)
    }

    override fun getMyEventList() = eventDao.getMyEventList().map { eventList ->
        eventList.map { event ->
            mapper.mapEventTableToEvent(event)
        }
    }

    override suspend fun addMyEvent(event: Event) {
        eventDao.addMyEvent(mapper.mapEventToEventTable(event))
    }

    override suspend fun deleteMyEvent(id: Int) {
        eventDao.deleteMyEvent(id)
    }

    override fun isEventExists(id: Int) = eventDao.isEventExists(id)

    override fun getEventList() = eventListFlow.asSharedFlow()

    override fun getComingEventList() = eventListFlow.asSharedFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getEventListByTags() = tagsFlow.flatMapLatest { tags ->
        eventListFlow.asSharedFlow().map { eventList ->
            if (tags.isEmpty()) {
                eventList
            } else {
                eventList.filter { event ->
                    event.tags.containsAll(tags)
                }
            }
        }
    }

    override fun getCommunityEvents(communityId: Int) = eventListFlow.map { eventList ->
        eventList.filter { event ->
            event.communityId == communityId
        }
    }

    override fun getTags() = flow {
       emit(mockData.tags)
    }

    override suspend fun setFilterTags(tags: List<String>) {
        tagsFlow.emit(tags)
    }
}
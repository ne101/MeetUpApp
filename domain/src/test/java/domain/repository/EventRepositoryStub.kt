package domain.repository

import com.example.domain.entities.Event
import com.example.domain.repository.EventRepository
import domain.mockStub.MockDataStub
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

internal class EventRepositoryStub(
) : EventRepository {

    internal val mockDataStub = MockDataStub()
    private val eventFlow = MutableSharedFlow<Event>(replay = 1)
    private val eventListFlow = MutableSharedFlow<List<Event>>(replay = 1)
    private val tagsFlow = MutableStateFlow<List<String>>(emptyList())

    override fun getEvent() = eventFlow.asSharedFlow()

    override suspend fun fetchEvent(id: Int) {
       val event = mockDataStub.eventList[id]
        eventFlow.emit(event)
    }

    override suspend fun fetchEventList() {
        val events = mockDataStub.eventList
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

    override suspend fun deleteAllEvents() = TODO("Not yet implemented")

    override fun getMyEvent(id: Int) = TODO("Not yet implemented")


    override fun getMyEventList() = TODO("Not yet implemented")


    override suspend fun addMyEvent(event: Event) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMyEvent(id: Int) {
        TODO("Not yet implemented")
    }

    override fun isEventExists(id: Int) = TODO("Not yet implemented")

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
       emit(mockDataStub.tags)
    }

    override suspend fun setFilterTags(tags: List<String>) {
        tagsFlow.emit(tags)
    }
}
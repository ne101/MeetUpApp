package com.example.data.repository_impl


import com.example.data.local_data_base.mock.MockData
import com.example.data.mapper.Mapper
import com.example.domain.entities.Person
import com.example.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

internal class PersonRepositoryImpl(
    private val  mockData: MockData
) : PersonRepository {

    private val personListFlow = MutableSharedFlow<List<Person>>(replay = 1)
    override fun getPersonList() = personListFlow.asSharedFlow()

    override suspend fun fetchPersonList(eventId: Int) {
        val personList = mockData.eventList[eventId].personList
        personListFlow.emit(personList)
    }
}
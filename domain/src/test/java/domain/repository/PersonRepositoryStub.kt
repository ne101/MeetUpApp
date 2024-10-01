package domain.repository


import com.example.domain.entities.Person
import com.example.domain.repository.PersonRepository
import domain.mockStub.MockDataStub
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.koin.java.KoinJavaComponent.inject

class PersonRepositoryStub : PersonRepository {

    internal val mockDataStub = MockDataStub()
    private val personListFlow = MutableSharedFlow<List<Person>>(replay = 1)
    override fun getPersonList() = personListFlow.asSharedFlow()

    override suspend fun fetchPersonList(eventId: Int) {
        val personList = mockDataStub.eventList[eventId].personList
        personListFlow.emit(personList)
    }
}
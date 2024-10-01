package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.interactor.event_interactors.GetAllEventListInteractor
import domain.repository.EventRepositoryStub
import domain.repository.PersonRepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetAllEventListInteractorTest {

    @Test
    fun `test AllEventList returns valid data`() {
        runTest {
            val repository = EventRepositoryStub()
            var eventList: List<Event> = listOf()
            val useCase = GetAllEventListInteractor(repository)
            useCase.execute().collect {
                eventList = it
            }
            TestCase.assertTrue(eventList.isNotEmpty())
        }
    }
}
package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.interactor.event_interactors.GetActiveEventListInteractor
import domain.repository.EventRepositoryStub
import domain.repository.PersonRepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetActiveEventListInteractorTest {

    @Test
    fun `test ActiveEventList returns valid data`() {
        runTest {
            val repository = EventRepositoryStub()
            var eventList: List<Event> = listOf()
            val useCase = GetActiveEventListInteractor(repository)
            useCase.execute().collect {
                eventList = it
            }
            TestCase.assertTrue(eventList.isNotEmpty())
        }
    }
}
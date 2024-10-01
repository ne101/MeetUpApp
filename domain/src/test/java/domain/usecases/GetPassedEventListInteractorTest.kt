package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.interactor.event_interactors.GetPassedEventListInteractor
import domain.repository.EventRepositoryStub
import domain.repository.PersonRepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetPassedEventListInteractorTest {

    @Test
    fun `test PassedEventList returns valid data`() {
        runTest {
            val repository = EventRepositoryStub()
            var eventList: List<Event> = listOf()
            val useCase = GetPassedEventListInteractor(repository)
            useCase.execute().collect {
                eventList = it
            }
            TestCase.assertTrue(eventList.isNotEmpty())
        }
    }
}
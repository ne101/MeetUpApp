package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.usecases.GetEventListUseCase
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetEventListUseCaseTest {

    @Test
    fun `test EventList returns valid data`() {
        runTest {
            val repository = RepositoryStub()
            var eventList: List<Event> = listOf()
            val useCase = GetEventListUseCase(repository)
            useCase.execute().collect {
                eventList = it
            }
            TestCase.assertTrue(eventList.isNotEmpty())
        }
    }
}
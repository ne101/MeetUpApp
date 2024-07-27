package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.usecases.GetActiveEventListUseCase
import com.example.domain.usecases.GetEventUseCase
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetActiveEventListUseCaseTest {

    @Test
    fun `test ActiveEventList returns valid data`() {
        runTest {
            val repository = RepositoryStub()
            var eventList: List<Event> = listOf()
            val useCase = GetActiveEventListUseCase(repository)
            useCase.execute().collect {
                eventList = it
            }
            println(eventList)
            TestCase.assertTrue(eventList.isNotEmpty())
        }
    }
}
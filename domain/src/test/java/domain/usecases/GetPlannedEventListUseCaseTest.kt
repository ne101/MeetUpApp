package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.usecases.GetPlannedEventListUseCase
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetPlannedEventListUseCaseTest {

    @Test
    fun `test PlannedEventList returns valid data`() {
        runTest {
            val repository = RepositoryStub()
            var eventList: List<Event> = listOf()
            val useCase = GetPlannedEventListUseCase(repository)
            useCase.execute().collect {
                eventList = it
            }
            TestCase.assertTrue(eventList.isNotEmpty())
        }
    }
}
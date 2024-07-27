package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.usecases.GetAllEventListUseCase
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetAllEventListUseCaseTest {

    @Test
    fun `test AllEventList returns valid data`() {
        runTest {
            val repository = RepositoryStub()
            var eventList: List<Event> = listOf()
            val useCase = GetAllEventListUseCase(repository)
            useCase.execute().collect {
                eventList = it
            }
            TestCase.assertTrue(eventList.isNotEmpty())
        }
    }
}
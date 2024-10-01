package domain.usecases

import com.example.domain.interactor.event_interactors.FetchEventListInteractor
import com.example.domain.interactor.event_interactors.GetEventListInteractor
import domain.repository.EventRepositoryStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetEventListInteractorTest {

    private lateinit var getEveListInteractor: GetEventListInteractor
    private lateinit var fetchEveListInteractor: FetchEventListInteractor
    private val eventRepositoryStub = EventRepositoryStub()

    @Before
    fun setUp() = runTest {
        getEveListInteractor = GetEventListInteractor(eventRepositoryStub)
        fetchEveListInteractor = FetchEventListInteractor(eventRepositoryStub)
        fetchEveListInteractor.execute()
    }

    @Test
    fun `test CommunityList returns valid data`() = runTest {
        val expected = eventRepositoryStub.mockDataStub.eventList
        val actual = getEveListInteractor.execute().first()
        assertEquals(expected, actual)
    }
}
package domain.usecases

import com.example.domain.interactor.event_interactors.FetchEventInteractor
import com.example.domain.interactor.event_interactors.GetEventInteractor
import domain.repository.EventRepositoryStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetEventInteractorTest() {
    private lateinit var getEventInteractor: GetEventInteractor
    private lateinit var fetchPersonInteractor: FetchEventInteractor
    private val eventRepositoryStub = EventRepositoryStub()
    private val eventId = 1

    @Before
    fun setUp() = runTest {
        getEventInteractor = GetEventInteractor(eventRepositoryStub)
        fetchPersonInteractor = FetchEventInteractor(eventRepositoryStub)
        fetchPersonInteractor.execute(eventId)
    }

    @Test
    fun `test getEvent return valid id`() = runTest {
        val expectedId = eventRepositoryStub.mockDataStub.eventList[eventId].id
        val actualId = getEventInteractor.execute().first().id
        assertEquals(expectedId, actualId)
    }


    @Test
    fun `test getEvent return valid name`() = runTest {
        val expectedName = eventRepositoryStub.mockDataStub.eventList[eventId].eventName
        val actualName = getEventInteractor.execute().first().eventName
        assertEquals(expectedName, actualName)
    }

    @Test
    fun `test getEvent return valid date`() = runTest {

        val expectedDate = eventRepositoryStub.mockDataStub.eventList[eventId].date
        val actualDate = getEventInteractor.execute().first().date
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun `test getEvent return valid city`() = runTest {

        val expectedCity = eventRepositoryStub.mockDataStub.eventList[eventId].city
        val actualCity = getEventInteractor.execute().first().city
        assertEquals(expectedCity, actualCity)
    }

    @Test
    fun `test getEvent return valid street`() = runTest {
        val expectedStreet = eventRepositoryStub.mockDataStub.eventList[eventId].street
        val actualStreet = getEventInteractor.execute().first().street
        assertEquals(expectedStreet, actualStreet)
    }

    @Test
    fun `test getEvent return valid avatar`() = runTest {

        val expectedAvatar = eventRepositoryStub.mockDataStub.eventList[eventId].avatar
        val actualAvatar = getEventInteractor.execute().first().avatar
        assertEquals(expectedAvatar, actualAvatar)

    }

    @Test
    fun `test getEvent return valid chips`() = runTest {
        val expectedTags = eventRepositoryStub.mockDataStub.eventList[eventId].tags
        val actualTags = getEventInteractor.execute().first().tags
        assertEquals(expectedTags, actualTags)
    }

    @Test
    fun `test getEvent return valid finishStatus`() = runTest {
        val expectedFinishStatus = eventRepositoryStub.mockDataStub.eventList[eventId].finished
        val actualFinishStatus = getEventInteractor.execute().first().finished
        assertEquals(expectedFinishStatus, actualFinishStatus)
    }

    @Test
    fun `test getEvent return valid personList`() = runTest {
        val expectedPersonList = eventRepositoryStub.mockDataStub.eventList[eventId].personList
        val actualPersonList = getEventInteractor.execute().first().personList
        assertEquals(expectedPersonList, actualPersonList)
    }


    @Test
    fun `test getEvent return valid mapUrl`() = runTest {
        val expectedMapUrl = eventRepositoryStub.mockDataStub.eventList[eventId].mapUrl
        val actualMapUrl = getEventInteractor.execute().first().mapUrl
        assertEquals(expectedMapUrl, actualMapUrl)
    }
}
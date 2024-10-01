package domain.usecases

import com.example.domain.interactor.person_interactors.FetchPersonListInteractor
import com.example.domain.interactor.person_interactors.GetPersonListInteractor
import domain.repository.PersonRepositoryStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetPersonListInteractorTest {
    private lateinit var getPersonListInteractor: GetPersonListInteractor
    private lateinit var fetchPersonListInteractor: FetchPersonListInteractor
    private val personRepositoryStub = PersonRepositoryStub()
    private val eventId = 1

    @Before
    fun setUp() = runTest {
        getPersonListInteractor = GetPersonListInteractor(personRepositoryStub)
        fetchPersonListInteractor = FetchPersonListInteractor(personRepositoryStub)
        fetchPersonListInteractor.execute(eventId)
    }

    @Test
    fun `test PersonList return valid data`() = runTest {
        val expectedPersonList = personRepositoryStub.mockDataStub.eventList[eventId].personList
        val actualPersonList = getPersonListInteractor.execute().first()
        assertEquals(expectedPersonList, actualPersonList)
    }
}
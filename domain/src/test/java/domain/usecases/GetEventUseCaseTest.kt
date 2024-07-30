package domain.usecases

import com.example.domain.usecases.GetEventUseCase
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetEventUseCaseTest() {
    @Test
    fun `test getEvent return valid id`() {
        runTest {
            val repository = RepositoryStub()
            var eventId: Int = -1
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventId = it.id
            }
            TestCase.assertTrue(eventId >= 0)
        }
    }

    @Test
    fun `test getEvent return valid name`() {
        runTest {
            val repository = RepositoryStub()
            var eventName: String? = null
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventName = it.eventName
            }
            TestCase.assertTrue(!eventName.isNullOrBlank())
        }
    }

    @Test
    fun `test getEvent return valid data`() {
        runTest {
            val repository = RepositoryStub()
            var eventData: String = ""
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventData = it.data
            }
            TestCase.assertTrue(eventData.length == DATA_LENGTH)
        }
    }

    @Test
    fun `test getEvent return valid city`() {
        runTest {
            val repository = RepositoryStub()
            var eventCity: String = ""
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventCity = it.city
            }
            TestCase.assertTrue(eventCity.isNotBlank())
        }
    }
    @Test
    fun `test getEvent return valid street`() {
        runTest {
            val repository = RepositoryStub()
            var eventStreet: String = ""
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventStreet = it.street
            }
            TestCase.assertTrue(eventStreet.isNotBlank())
        }
    }

    @Test
    fun `test getEvent return valid avatar`() {
        runTest {
            val repository = RepositoryStub()
            var eventAvatar: String = ""
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventAvatar = it.avatar
            }
            TestCase.assertTrue(eventAvatar.isNotBlank())
        }
    }

    @Test
    fun `test getEvent return valid chips`() {
        runTest {
            val repository = RepositoryStub()
            var eventChips = listOf<String>()
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventChips = it.chips
            }
            TestCase.assertTrue(eventChips.isNotEmpty())
        }
    }

    @Test
    fun `test getEvent return valid finishStatus`() {
        runTest {
            val repository = RepositoryStub()
            var eventFinishStatus: Boolean? = null
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventFinishStatus = it.finished
            }
            TestCase.assertTrue(eventFinishStatus != null)
        }
    }

    @Test
    fun `test getEvent return valid usersImageList`() {
        runTest {
            val repository = RepositoryStub()
            var eventUsersImageList = listOf<String>()
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventUsersImageList = it.imageList
            }
            TestCase.assertTrue(eventUsersImageList.isNotEmpty())
        }
    }
    @Test
    fun `test getEvent return valid mapUrl`() {
        runTest {
            val repository = RepositoryStub()
            var eventMapUrl: String = ""
            val useCase = GetEventUseCase(repository)
            useCase.execute().collect {
                eventMapUrl = it.mapUrl
            }
            TestCase.assertTrue(eventMapUrl.isNotBlank())
        }
    }



    companion object {
        private const val DATA_LENGTH = 10
    }
}
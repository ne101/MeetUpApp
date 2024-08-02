package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.interactor.GetProfileInteractor
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetProfileInteractorTest {

    @Test
    fun `test profile returns valid name`() {
        runTest {
            val repository = RepositoryStub()
            var profileName = ""
            val useCase = GetProfileInteractor(repository)
            useCase.execute(0).collect {
                profileName = it.name
            }
            TestCase.assertTrue(profileName.isNotEmpty())
        }
    }

    @Test
    fun `test profile returns valid phone`() {
        runTest {
            val repository = RepositoryStub()
            var profilePhone = ""
            val useCase = GetProfileInteractor(repository)
            useCase.execute(0).collect {
                profilePhone = it.phone
            }
            TestCase.assertTrue(profilePhone
                .replace("+", "")
                .replace("-", "")
                .replace(" ", "")
                .length == PHONE_LENGTH)
        }
    }

    @Test
    fun `test profile returns valid avatar`() {
        runTest {
            val repository = RepositoryStub()
            var profileAvatar = ""
            val useCase = GetProfileInteractor(repository)
            useCase.execute(0).collect {
                profileAvatar = it.avatar.toString()
            }
            TestCase.assertTrue(profileAvatar.isNotEmpty())
        }
    }

    @Test
    fun `test profile returns valid events`() {
        runTest {
            val repository = RepositoryStub()
            var events: List<Event> = listOf()
            val useCase = GetProfileInteractor(repository)
            useCase.execute(0).collect {
                events = it.events
            }
            TestCase.assertTrue(events.isNotEmpty())
        }
    }

    companion object {
        private const val PHONE_LENGTH = 11
    }
}
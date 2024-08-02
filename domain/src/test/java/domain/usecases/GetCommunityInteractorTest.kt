package domain.usecases

import com.example.domain.entities.Event
import com.example.domain.interactor.GetCommunityInteractor
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetCommunityInteractorTest {

    @Test
    fun `test Community returns valid name`() {
        runTest {
            val repository = RepositoryStub()
            var communityName: String = ""
            val useCase = GetCommunityInteractor(repository)
            useCase.execute(0).collect {
                communityName = it.communityName
            }
            TestCase.assertTrue(communityName.isNotBlank())
        }
    }

    @Test
    fun `test Community returns valid count subscribers`() {
        runTest {
            val repository = RepositoryStub()
            var communityCountSubscribers: Int = -1
            val useCase = GetCommunityInteractor(repository)
            useCase.execute(0).collect {
                communityCountSubscribers = it.countSubscribers
            }
            TestCase.assertTrue(communityCountSubscribers >= 0)
        }
    }

    @Test
    fun `test Community returns valid avatar community`() {
        runTest {
            val repository = RepositoryStub()
            var avatarCommunity: String = ""
            val useCase = GetCommunityInteractor(repository)
            useCase.execute(0).collect {
                avatarCommunity = it.avatarCommunity
            }
            TestCase.assertTrue(avatarCommunity.isNotBlank())
        }
    }

    @Test
    fun `test Community returns valid id`() {
        runTest {
            val repository = RepositoryStub()
            var avatarId: Int = -1
            val useCase = GetCommunityInteractor(repository)
            useCase.execute(0).collect {
                avatarId = it.id
            }
            TestCase.assertTrue(avatarId >= 0)
        }
    }

    @Test
    fun `test Community returns valid community events`() {
        runTest {
            val repository = RepositoryStub()
            var communityEvent = listOf<Event>()
            val useCase = GetCommunityInteractor(repository)
            useCase.execute(0).collect {
                communityEvent = it.events
            }
            TestCase.assertTrue(communityEvent.isNotEmpty())
        }
    }

    @Test
    fun `test Community returns valid description`() {
        runTest {
            val repository = RepositoryStub()
            var communityDescription: String = ""
            val useCase = GetCommunityInteractor(repository)
            useCase.execute(0).collect {
                communityDescription = it.description
            }
            TestCase.assertTrue(communityDescription.isNotBlank())
        }
    }
}
package domain.usecases

import com.example.domain.entities.Community
import com.example.domain.interactor.GetCommunityListInteractor
import domain.repository.RepositoryStub
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetCommunityListInteractorTest {

    @Test
    fun `test CommunityList returns valid data`() {
        runTest {
            val repository = RepositoryStub()
            var communityList: List<Community> = listOf()
            val useCase = GetCommunityListInteractor(repository)
            useCase.execute().collect {
                communityList = it
            }
            TestCase.assertTrue(communityList.isNotEmpty())
        }
    }
}
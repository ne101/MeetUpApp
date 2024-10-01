package domain.usecases

import com.example.domain.interactor.community_interactors.FetchCommunityInteractor
import com.example.domain.interactor.community_interactors.GetCommunityInteractor
import domain.repository.CommunityRepositoryStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetCommunityInteractorTest {

    private lateinit var getCommunityInteractor: GetCommunityInteractor
    private lateinit var fetchCommunityInteractor: FetchCommunityInteractor
    private val repository = CommunityRepositoryStub()
    private val communityId = 1

    @Before
    fun setUp() = runTest {
        getCommunityInteractor = GetCommunityInteractor(repository)
        fetchCommunityInteractor = FetchCommunityInteractor(repository)
        fetchCommunityInteractor.execute(communityId)
    }

    @Test
    fun `test Community returns valid name`() = runTest {
        val expectedName = repository.mockDataStub.communityList[communityId].communityName
        val actualName = getCommunityInteractor.execute().first().communityName
        assertEquals(expectedName, actualName)
    }

    @Test
    fun `test Community returns valid count subscribers`() = runTest {
        val expectedCountSubscribers =
            repository.mockDataStub.communityList[communityId].personList.count()
        val actualCountSubscribers = getCommunityInteractor.execute().first().personList.count()
        assertEquals(expectedCountSubscribers, actualCountSubscribers)
    }

    @Test
    fun `test Community returns valid avatar community`() = runTest {
        val expectedAvatar = repository.mockDataStub.communityList[communityId].avatarCommunity
        val actualAvatar = getCommunityInteractor.execute().first().avatarCommunity
        assertEquals(expectedAvatar, actualAvatar)
    }

    @Test
    fun `test Community returns valid id`() = runTest {
        val expectedId = repository.mockDataStub.communityList[communityId].id
        val actualId = getCommunityInteractor.execute().first().id
        assertEquals(expectedId, actualId)
    }

    @Test
    fun `test Community returns valid tags`() = runTest {
        val expectedTags = repository.mockDataStub.communityList[communityId].tags
        val actualTags = getCommunityInteractor.execute().first().tags
        assertEquals(expectedTags, actualTags)
    }

    @Test
    fun `test Community returns valid description`() = runTest {
        val expectedDescription = repository.mockDataStub.communityList[communityId].description
        val actualDescription = getCommunityInteractor.execute().first().description
        assertEquals(expectedDescription, actualDescription)

    }

}
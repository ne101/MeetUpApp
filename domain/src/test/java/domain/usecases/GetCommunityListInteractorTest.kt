package domain.usecases

import com.example.domain.interactor.community_interactors.FetchCommunityListInteractor
import com.example.domain.interactor.community_interactors.GetCommunityListInteractor
import domain.repository.CommunityRepositoryStub
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetCommunityListInteractorTest {
    private lateinit var getCommunityListInteractor: GetCommunityListInteractor
    private lateinit var fetchCommunityListInteractor: FetchCommunityListInteractor
    private val communityRepositoryStub = CommunityRepositoryStub()

    @Before
    fun setUp() = runTest {
        fetchCommunityListInteractor = FetchCommunityListInteractor(communityRepositoryStub)
        getCommunityListInteractor = GetCommunityListInteractor(communityRepositoryStub)
        fetchCommunityListInteractor.execute()
    }

    @Test
    fun `test CommunityList returns valid data`() = runTest {
        val expected = communityRepositoryStub.mockDataStub.communityList
        val actual = getCommunityListInteractor.execute().first()
        assertEquals(expected, actual)
    }
}
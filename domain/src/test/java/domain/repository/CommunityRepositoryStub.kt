package domain.repository

import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository
import domain.mockStub.MockDataStub
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map

internal class CommunityRepositoryStub(
) : CommunityRepository {
    internal val mockDataStub = MockDataStub()
    private val communityFlow = MutableSharedFlow<Community>(replay = 1)
    private val communityListFlow = MutableSharedFlow<List<Community>>(replay = 1)

    override fun getCommunity() = communityFlow.asSharedFlow()

    override suspend fun fetchCommunity(id: Int) {
        val community = mockDataStub.communityList[id]
        communityFlow.emit(community)
    }

    override suspend fun fetchCommunityList() {
        val communityList = mockDataStub.communityList
        communityListFlow.emit(communityList)
    }

    override suspend fun deleteAllCommunities() {
        TODO("Not yet implemented")
    }

    override fun getMyCommunity(id: Int): Flow<Community> {
        TODO("Not yet implemented")
    }

    override fun getMyCommunityList(): Flow<List<Community>> {
        TODO("Not yet implemented")
    }

    override suspend fun addMyCommunity(community: Community) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMyCommunity(id: Int) {
        TODO("Not yet implemented")
    }

    override fun isCommunityExists(id: Int) = TODO("Not yet implemented")

    override fun getCommunityList() = communityListFlow.asSharedFlow()

}
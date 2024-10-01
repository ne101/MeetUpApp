package com.example.data.repository_impl

import com.example.data.local_data_base.dao.CommunityDao
import com.example.data.local_data_base.mock.MockData
import com.example.data.mapper.Mapper
import com.example.domain.entities.Community
import com.example.domain.repository.CommunityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map

internal class CommunityRepositoryImpl(
    private val communityDao: CommunityDao,
    private val mockData: MockData,
    private val mapper: Mapper
) : CommunityRepository {
    private val communityFlow = MutableSharedFlow<Community>(replay = 1)
    private val communityListFlow = MutableSharedFlow<List<Community>>(replay = 1)

    override fun getCommunity() = communityFlow.asSharedFlow()

    override suspend fun fetchCommunity(id: Int) {
        val community = mockData.communityList[id]
        communityFlow.emit(community)
    }

    override suspend fun fetchCommunityList() {
        val communityList = mockData.communityList
        communityListFlow.emit(communityList)
    }

    override suspend fun deleteAllCommunities() {
        communityDao.deleteAllCommunities()
    }

    override fun getMyCommunity(id: Int) = communityDao.getMyCommunity(id).map {
        mapper.mapCommunityTableToCommunity(it)
    }

    override fun getMyCommunityList(): Flow<List<Community>> = communityDao
        .getMyCommunityList().map { communityList ->
        communityList.map { community ->
            mapper.mapCommunityTableToCommunity(community)
        }
    }

    override suspend fun addMyCommunity(community: Community) {
        communityDao.addMyCommunity(mapper.mapCommunityToCommunityTable(community))
    }

    override suspend fun deleteMyCommunity(id: Int) {
        communityDao.deleteMyCommunity(id)
    }

    override fun isCommunityExists(id: Int) = communityDao.isCommunityExists(id)

    override fun getCommunityList() = communityListFlow.asSharedFlow()

}
package com.example.domain.repository

import com.example.domain.entities.Community
import kotlinx.coroutines.flow.Flow

interface CommunityRepository {

    fun getCommunity(): Flow<Community>
    suspend fun fetchCommunity(id: Int)
    suspend fun fetchCommunityList()
    suspend fun deleteAllCommunities()
    fun getMyCommunity(id: Int): Flow<Community>
    fun getMyCommunityList(): Flow<List<Community>>
    suspend fun addMyCommunity(community: Community)
    suspend fun deleteMyCommunity(id: Int)
    fun isCommunityExists(id: Int): Flow<Boolean>
    fun getCommunityList(): Flow<List<Community>>
}
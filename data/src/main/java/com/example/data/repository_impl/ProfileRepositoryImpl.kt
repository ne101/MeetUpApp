package com.example.data.repository_impl

import com.example.data.local_data_base.dao.ProfileDao
import com.example.data.mapper.Mapper
import com.example.domain.entities.Profile
import com.example.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ProfileRepositoryImpl(
    private val profileDao: ProfileDao,
    private val mapper: Mapper
) : ProfileRepository {
    override fun getProfile() = profileDao.getProfile().map {
        mapper.mapProfileTableToProfile(it)
    }

    override suspend fun saveProfile(profile: Profile) {
        profileDao.saveProfile(mapper.mapProfileToProfileTable(profile))
    }

    override suspend fun deleteProfile() {
        profileDao.deleteProfile()
    }

    override fun isProfileExists() = profileDao.isProfileExists()

    override suspend fun updateProfile(profile: Profile) {
        profileDao.updateProfile(mapper.mapProfileToProfileTable(profile))
    }
}
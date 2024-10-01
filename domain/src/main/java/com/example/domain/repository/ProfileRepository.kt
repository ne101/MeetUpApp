package com.example.domain.repository

import com.example.domain.entities.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getProfile(): Flow<Profile>
    suspend fun saveProfile(profile: Profile)
    suspend fun deleteProfile()
    fun isProfileExists(): Flow<Boolean>
    suspend fun updateProfile(profile: Profile)
}
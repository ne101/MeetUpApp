package com.example.domain.repository

import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile

interface Repository {
    fun getEvent(): Event
    fun getEventList(): List<Event>
    fun getCommunity(): Community
    fun getCommunityList(): List<Community>
    fun getProfile(): Profile
}
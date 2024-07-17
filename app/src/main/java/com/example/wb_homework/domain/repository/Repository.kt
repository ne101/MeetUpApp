package com.example.wb_homework.domain.repository

import com.example.wb_homework.domain.entities.Community
import com.example.wb_homework.domain.entities.Event
import com.example.wb_homework.domain.entities.Profile

interface Repository {
    fun getEvent(): Event
    fun getEventList(): List<Event>
    fun getCommunity(): Community
    fun getCommunityList(): List<Community>
    fun getProfile(): Profile
}
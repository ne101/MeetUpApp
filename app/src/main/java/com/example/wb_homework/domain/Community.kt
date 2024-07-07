package com.example.wb_homework.domain

import com.example.wb_homework.R

data class Community(
    val communityName: String = "Designa",
    val countSubscribers: String = "10000 человек",
    val avatarCommunityId: Int = R.drawable.avatar_community,
    val id: Int = 0
)
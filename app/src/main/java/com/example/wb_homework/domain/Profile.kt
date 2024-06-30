package com.example.wb_homework.domain

import com.example.wb_homework.R

data class Profile(
    val name: String = "Иван Иванов",
    val phone: String = "+7 999 999-99-99",
    val avatarResId: Int = R.drawable.avatar

)
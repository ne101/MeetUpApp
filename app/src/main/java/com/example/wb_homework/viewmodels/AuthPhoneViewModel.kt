package com.example.wb_homework.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthPhoneViewModel : ViewModel() {
    private val _phoneNumber = MutableStateFlow("")
    private val phoneNumber = _phoneNumber.asStateFlow()

    fun getPhoneNumber() = phoneNumber
    fun setPhoneNumber(phoneNumber: String) {
        _phoneNumber.value = phoneNumber
    }
}
package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.custom_code_field.CustomCodeField
import com.example.wb_homework.ui.custom_phone_field.CustomPhoneField

@Composable
fun CustomUI() {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomPhoneField()
        Spacer(modifier = Modifier.height(16.dp))
        CustomCodeField()
    }
    
}
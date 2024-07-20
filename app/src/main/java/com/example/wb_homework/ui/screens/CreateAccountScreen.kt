package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.entities.AvatarState.Edit
import com.example.wb_homework.R
import com.example.wb_homework.ui.ui_kit.AvatarProfile
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.InputText
import com.example.wb_homework.ui.ui_kit.PrimaryDisabledButton
import com.example.wb_homework.ui.ui_kit.PrimaryInitialButton
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.viewmodels.CreateAccountViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAccountScreen(
    launchEventScreen: () -> Unit,
) {
    val viewModel: CreateAccountViewModel = koinViewModel()
    var onCompletePhone by remember {
        mutableStateOf(false)
    }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Color.White,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified

                ), title = {
                    Subheading1(
                        text = stringResource(id = R.string.profile)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        ImageIcon(iconResId = R.drawable.back_icon)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AvatarProfile(
                avatar = R.drawable.avatar,
                modifier = Modifier.size(100.dp),
                state = Edit
            )
            Spacer(modifier = Modifier.height(30.dp))
            InputText(
                textPlaceHolder = stringResource(id = R.string.name),
                necessarily = true
            ) {
                onCompletePhone = it
            }
            Spacer(modifier = Modifier.height(12.dp))
            InputText(
                textPlaceHolder = stringResource(id = R.string.surname),
                necessarily = false,
                onComplete = {}
            )
            Spacer(modifier = Modifier.height(56.dp))
            if (onCompletePhone) {
                PrimaryInitialButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.save)
                ) {
                    launchEventScreen()
                }
            } else {
                PrimaryDisabledButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.save)
                )
            }
        }
    }
}
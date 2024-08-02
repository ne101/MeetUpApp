package com.example.wb_homework.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.entities.Profile
import com.example.wb_homework.R
import com.example.wb_homework.screen_states.CreateAccountScreenState
import com.example.wb_homework.ui.ui_kit.AvatarProfileRegistration
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.InputText
import com.example.wb_homework.ui.ui_kit.PrimaryDisabledButton
import com.example.wb_homework.ui.ui_kit.PrimaryInitialButton
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.viewmodels.CreateAccountViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CreateAccountScreen(
    launchEventScreen: () -> Unit,
    phoneNumber: String,
    viewModel: CreateAccountViewModel = koinViewModel(),
) {
    val screenState = viewModel.getScreenState().collectAsStateWithLifecycle()
    viewModel.updatePhoneNumber(phoneNumber)
    var onComplete by remember {
        mutableStateOf(false)
    }
    var imageUri: Any? by remember {
        mutableStateOf(null)
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        imageUri = it
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
                    IconButton(onClick = { }) {
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
            AvatarProfileRegistration(
                avatar = imageUri,
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .size(100.dp)
                    .clickable(
                        enabled = imageUri == null
                    ) {
                        if (imageUri == null) {
                            launcher.launch("image/*")
                        }
                    },
            )
            Spacer(modifier = Modifier.height(30.dp))
            InputText(
                textPlaceHolder = stringResource(id = R.string.name),
                necessarily = true,
                onComplete = { onComplete = it },
                name = { viewModel.updateName(it) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            InputText(
                textPlaceHolder = stringResource(id = R.string.surname),
                necessarily = false,
                onComplete = {},
                name = { viewModel.updateSecondName(it) }
            )
            Spacer(modifier = Modifier.height(56.dp))
            when (val currentState = screenState.value) {
                is CreateAccountScreenState.UserData -> {
                    SaveUserData(
                        onComplete = onComplete,
                        viewModel = viewModel,
                        currentState = currentState,
                        imageUri = imageUri
                    ) {
                        launchEventScreen()
                    }
                }

                CreateAccountScreenState.Initial -> {}
            }

        }
    }
}

@Composable
private fun SaveUserData(
    onComplete: Boolean,
    viewModel: CreateAccountViewModel,
    currentState: CreateAccountScreenState.UserData,
    imageUri: Any?,
    launchEventScreen: () -> Unit,
) {
    if (onComplete) {
        PrimaryInitialButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.save)
        ) {
            viewModel.saveProfile(
                Profile(
                    name = currentState.profile.name,
                    secondName = currentState.profile.secondName,
                    phone = currentState.profile.phone,
                    events = currentState.profile.events,
                    avatar = imageUri
                )
            )
            launchEventScreen()
        }
    } else {
        PrimaryDisabledButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.save)
        )
    }
}
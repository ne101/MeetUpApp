package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Profile
import com.example.wb_homework.R
import com.example.wb_homework.screen_states.ProfileScreenState
import com.example.wb_homework.ui.theme.PhoneColor
import com.example.wb_homework.ui.ui_kit.AvatarProfile
import com.example.wb_homework.ui.ui_kit.ButtonWithIcon
import com.example.wb_homework.ui.ui_kit.Heading2
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.ui.ui_kit.Subheading2
import com.example.wb_homework.viewmodels.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    onBackPressed: () -> Unit,
    viewModel: ProfileViewModel = koinViewModel()
) {
    val screenState = viewModel.getScreenState().collectAsState(ProfileScreenState.Initial)
    when (val currentState = screenState.value) {
        is ProfileScreenState.ProfileInfo -> {
            ProfileComponent(profile = currentState.profile) {
                onBackPressed()
            }
        }

        ProfileScreenState.Initial -> {}
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileComponent(
    profile: Profile,
    onBackPressed: () -> Unit,
) {
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

                ),
                title = {
                    Subheading1(text = stringResource(id = R.string.profile))
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        ImageIcon(iconResId = R.drawable.back_icon, modifier = Modifier.size(24.dp))
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        ImageIcon(iconResId = R.drawable.edit_icon, modifier = Modifier.size(24.dp))
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            AvatarProfile(
                avatar = profile.avatar,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(100.dp))
            )
            Spacer(modifier = Modifier.height(20.dp))
            Heading2(profile.name)
            Subheading2(profile.phone, color = PhoneColor)
            Spacer(modifier = Modifier.height(40.dp))
            RowIcons()
        }
    }
}

@Composable
fun RowIcons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ButtonWithIcon(
            icon = R.drawable.twitter_icon,
            verticalPadding = 10.dp,
            horizontalPadding = 25.dp
        )
        ButtonWithIcon(
            verticalPadding = 10.dp,
            icon = R.drawable.instagram_icon,
            horizontalPadding = 25.dp
        )
        ButtonWithIcon(
            icon = R.drawable.in_icon,
            verticalPadding = 10.dp,
            horizontalPadding = 25.dp
        )
        ButtonWithIcon(
            icon = R.drawable.facebook_icon,
            verticalPadding = 10.dp,
            horizontalPadding = 25.dp
        )
    }
}
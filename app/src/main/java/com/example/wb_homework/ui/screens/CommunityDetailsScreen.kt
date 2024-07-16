package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.domain.entities.Community
import com.example.wb_homework.domain.entities.Event
import com.example.wb_homework.screen_states.CommunityDetailsScreenState
import com.example.wb_homework.ui.theme.GrayDefault
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.EventCard
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.MetaData1
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.viewmodels.CommunityDetailsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CommunityDetailsScreen(
    onBackPressedClickListener: () -> Unit,
    onEventCardClickListener: () -> Unit,
) {
    val viewModel: CommunityDetailsViewModel = koinViewModel()
    val screenState = viewModel.getScreenState().collectAsState(CommunityDetailsScreenState.Initial)
    viewModel.loadCommunity()
    when (val currentState = screenState.value) {
        is CommunityDetailsScreenState.CommunityDetails -> {
            CommunityDetails(
                community = currentState.community,
                events = currentState.community.events,
                onEventCardClickListener = { onEventCardClickListener() },
                onBackPressedClickListener = { onBackPressedClickListener() }
            )
        }

        CommunityDetailsScreenState.Initial -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityDetails(
    community: Community,
    events: List<Event>,
    onEventCardClickListener: () -> Unit,
    onBackPressedClickListener: () -> Unit,
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
                    Subheading1(text = community.communityName)
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressedClickListener() }) {
                        ImageIcon(
                            iconResId = R.drawable.back_icon,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MetaData1(
                text = community.description,
                color = GrayDefault,
                modifier = Modifier.padding(bottom = 14.dp)
            )
            BodyText1(
                text = stringResource(id = R.string.community_events),
                color = GrayDefault
            )
            LazyColumn(
                modifier = Modifier.padding(bottom = 72.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = events, key = { it.id }) {
                    EventCard(
                        event = it,
                        onEventCardClickListener = {
                            onEventCardClickListener()
                        }
                    )
                }
            }
        }
    }
}


package com.example.wb_homework.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.wb_homework.R
import com.example.wb_homework.ui.screen_state.CommunityScreenState
import com.example.wb_homework.ui.state.ButtonState
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.OverlappingImageList
import com.example.wb_homework.ui.update_ui_kit.CardAvatar
import com.example.wb_homework.ui.update_ui_kit.EventCardThin
import com.example.wb_homework.ui.update_ui_kit.EventCardWide
import com.example.wb_homework.ui.update_ui_kit.InitialScreen
import com.example.wb_homework.ui.update_ui_kit.MainButton
import com.example.wb_homework.ui.update_ui_kit.TagMedium
import com.example.wb_homework.ui.update_ui_kit.TextH1
import com.example.wb_homework.ui.update_ui_kit.TextH2
import com.example.wb_homework.ui.update_ui_kit.TextPrimary
import com.example.wb_homework.ui.update_ui_kit.TextSecondary
import com.example.wb_homework.ui.utils.maxHeightInLazyRow
import com.example.wb_homework.viewmodels.CommunityViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CommunityScreen(
    onEventClickListener: (Int, Int) -> Unit,
    onBackClickListener: () -> Unit,
    communityId: Int,
    viewModel: CommunityViewModel = koinViewModel(
        parameters = { parametersOf(communityId) }
    )
) {
    val screenState = viewModel.getScreenState().collectAsStateWithLifecycle()
    when (val currentScreenState = screenState.value) {
        is CommunityScreenState.MainContent -> {
            CommunityContent(
                currentScreenState = currentScreenState,
                viewModel = viewModel,
                onEventClickListener = onEventClickListener,
                onBackClickListener = onBackClickListener
            )
        }

        is CommunityScreenState.Error -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Error: ${currentScreenState.message}")
                MainButton(
                    text = stringResource(R.string.try_again),
                    buttonState = ButtonState.Primary
                ) {
                    viewModel.fetchInitialData()
                }
            }
        }

        CommunityScreenState.Initial -> {
            InitialScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityContent(
    currentScreenState: CommunityScreenState.MainContent,
    viewModel: CommunityViewModel,
    onEventClickListener: (Int, Int) -> Unit,
    onBackClickListener: () -> Unit
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
                    TextPrimary(
                        text = currentScreenState.community.communityName + currentScreenState.community.id,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClickListener() }) {
                        ImageIcon(
                            iconResId = R.drawable.back_icon,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        ImageIcon(iconResId = R.drawable.share_icon)
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            item {
                CommunityHead(community = currentScreenState.community)
            }
            item {
                ButtonAndText(currentScreenState = currentScreenState, viewModel = viewModel)
            }
            item {
                TextSecondary(
                    text = currentScreenState.community.description,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            item {
                OverlappingImageList(
                    community = currentScreenState.community,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            items(
                currentScreenState.eventList,
                key = { it.id }
            ) {
                Events(event = it, events = currentScreenState.eventList) { eventId, communityId ->
                    onEventClickListener(eventId, communityId)
                }
            }
            item {
                PastEvents(events = currentScreenState.finishedEventList) { eventId, communityId ->
                    onEventClickListener(eventId, communityId)
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CommunityHead(community: Community) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        CardAvatar(
            modifier = Modifier.size(167.dp),
            avatar = community.avatarCommunity
        )
        TextH1(text = community.communityName + community.id)
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(community.tags.size) {
                TagMedium(category = community.tags[it], enable = false) {}
            }
        }
    }
}

@Composable
private fun ButtonAndText(
    currentScreenState: CommunityScreenState.MainContent,
    viewModel: CommunityViewModel
) {
    val text = if (currentScreenState.isCommunityExists) {
        stringResource(R.string.you_are_subscribed)
    } else {
        stringResource(R.string.subscribe)
    }
    val buttonState = if (currentScreenState.isCommunityExists) {
        ButtonState.Secondary
    } else {
        ButtonState.Primary
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MainButton(
            text = text,
            buttonState = buttonState
        ) {
            viewModel.updateSubscribeStatus(currentScreenState.community)
        }
        TextSecondary(
            text = stringResource(R.string.we_will_invite_you),
            color = PurpleWB
        )
    }
}

@Composable
private fun PastEvents(events: List<Event>, onEventClickListener: (Int, Int) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextH1(text = stringResource(R.string.past_events))
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.maxHeightInLazyRow()
        ) {
            items(events, key = { it.id }) {
                if (it.id == events.first().id) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
                EventCardThin(event = it) { eventId, communityId ->
                    onEventClickListener(eventId, communityId)
                }
                if (it.id == events.last().id) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
private fun Events(event: Event, events: List<Event>, onEventClickListener: (Int, Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (event == events.first()) {
            TextH2(text = stringResource(id = R.string.meet))
        }
        EventCardWide(
            event = event,
            modifier = Modifier.clickable {
                onEventClickListener(
                    event.id,
                    event.communityId
                )
            }
        )
    }
}

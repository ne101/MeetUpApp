package com.example.wb_homework.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.wb_homework.R
import com.example.wb_homework.ui.screen_state.EventScreenState
import com.example.wb_homework.ui.state.ButtonState
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.theme.ShadowColor
import com.example.wb_homework.ui.theme.colorDate
import com.example.wb_homework.ui.theme.textColorGreen
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.OverlappingImageList
import com.example.wb_homework.ui.update_ui_kit.CardAvatar
import com.example.wb_homework.ui.update_ui_kit.EventCardThin
import com.example.wb_homework.ui.update_ui_kit.InitialScreen
import com.example.wb_homework.ui.update_ui_kit.MainButton
import com.example.wb_homework.ui.update_ui_kit.TagMedium
import com.example.wb_homework.ui.update_ui_kit.TextH1
import com.example.wb_homework.ui.update_ui_kit.TextH2
import com.example.wb_homework.ui.update_ui_kit.TextH4
import com.example.wb_homework.ui.update_ui_kit.TextPrimary
import com.example.wb_homework.ui.update_ui_kit.TextSecondary
import com.example.wb_homework.ui.utils.maxHeightInLazyRow
import com.example.wb_homework.viewmodels.EventViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun EventScreen(
    eventId: Int,
    communityId: Int,
    viewModel: EventViewModel = koinViewModel(
        parameters = { parametersOf(eventId, communityId) }
    ),
    onEventClickListener: (Int, Int) -> Unit,
    onCommunityClickListener: (Int) -> Unit,
    onBackClickListener: () -> Unit,
    onPersonClickListener: (String) -> Unit
) {
    val screenState = viewModel.getScreenStateFlow().collectAsStateWithLifecycle()
    when (val currentScreenState = screenState.value) {
        is EventScreenState.MainContent -> {
            EventContent(
                viewModel = viewModel,
                currentScreenState = currentScreenState,
                onEventClickListener = onEventClickListener,
                onCommunityClickListener = onCommunityClickListener,
                onBackClickListener = onBackClickListener,
                onPersonClickListener = onPersonClickListener
            )
        }

        is EventScreenState.Error -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Error: ${currentScreenState.message}")
                MainButton(
                    text = stringResource(id = R.string.try_again),
                    buttonState = ButtonState.Primary
                ) {
                    viewModel.fetchInitialData()
                }
            }
        }

        EventScreenState.Initial -> {
            InitialScreen()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EventContent(
    viewModel: EventViewModel,
    currentScreenState: EventScreenState.MainContent,
    onEventClickListener: (Int, Int) -> Unit,
    onCommunityClickListener: (Int) -> Unit,
    onBackClickListener: () -> Unit,
    onPersonClickListener: (String) -> Unit
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
                        text = currentScreenState.event.eventName + currentScreenState.event.id,
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
        },

        bottomBar = {
            if (currentScreenState.event.finished.not()) {
                SingUpOnEvent(
                    currentScreenState.event,
                    currentScreenState.isEventExists,
                    viewModel = viewModel
                )
            }
        }
    ) {
        Box {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier
                    .padding(it)
                    .background(Color.White),
            ) {
                item {
                    EventHead(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        event = currentScreenState.event
                    )
                }

                item {
                    TextSecondary(
                        text = currentScreenState.event.description,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                item {
                    EventHostCard(
                        event = currentScreenState.event,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                item {
                    OverlappingImageList(
                        event = currentScreenState.event,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) { title ->
                        onPersonClickListener(title)
                    }
                }

                item {
                    CommunityCardForEvent(
                        community = currentScreenState.community,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) { id ->
                        onCommunityClickListener(id)
                    }
                }

                item {
                    OtherEvents(
                        events = currentScreenState.eventsByCommunity
                    ) { eventId, communityId ->
                        onEventClickListener(eventId, communityId)
                    }
                }
            }
        }
    }
}

@Composable
private fun EventHostCard(
    modifier: Modifier = Modifier,
    event: Event
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        TextH2(text = stringResource(R.string.host))
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Column(modifier = Modifier.weight(1f)) {
                TextH4(text = event.eventHostName)
                TextSecondary(text = event.descriptionByHost)
            }
            CardAvatar(
                avatar = event.avatarHost,
                modifier = Modifier
                    .size(104.dp)
                    .align(alignment = Alignment.Bottom)
            )
        }
    }
}

@Composable
private fun CommunityCardForEvent(
    modifier: Modifier = Modifier,
    community: Community,
    onCommunityClickListener: (Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        TextH2(text = stringResource(R.string.organizer))
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.clickable { onCommunityClickListener(community.id) }
        ) {
            Column(modifier = Modifier.weight(1f)) {
                TextH4(text = community.communityName + community.id)
                TextSecondary(text = community.description)
            }
            CardAvatar(
                avatar = community.avatarCommunity,
                modifier = Modifier
                    .size(104.dp)
                    .align(alignment = Alignment.Bottom)
            )
        }
    }
}

@Composable
private fun OtherEvents(
    events: List<Event>,
    onEventClickListener: (Int, Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextH2(
            text = stringResource(R.string.other_community_events),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
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
fun SingUpOnEvent(
    event: Event,
    isEventExists: Boolean,
    viewModel: EventViewModel,
    modifier: Modifier = Modifier,
) {
    val text = if (isEventExists) {
        stringResource(R.string.we_are_going)
    } else {
        stringResource(
            id = R.string.sing_up_on_the_event,
            event.numberOfSeats
        )
    }
    val textButton = if (isEventExists) {
        stringResource(R.string.cant_going)
    } else {
        stringResource(R.string.sing_up_on_event)
    }

    val buttonState = if (isEventExists) {
        ButtonState.Secondary
    } else {
        ButtonState.Primary
    }
    val colorText = if (isEventExists) {
        textColorGreen
    } else {
        PurpleWB
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .shadow(
                32.dp,
                ambientColor = ShadowColor,
                clip = true
            )
            .border(1.dp, ShadowColor, RoundedCornerShape(24.dp))
            .clip(shape = RoundedCornerShape(24.dp))
            .background(
                Color.White,
            )
            .padding(
                start = 16.dp,
                top = 10.dp,
                end = 16.dp,
                bottom = 24.dp
            )
    ) {
        TextSecondary(
            text = text,
            color = colorText,
            textAlign = TextAlign.Center
        )
        MainButton(
            text = textButton,
            buttonState = buttonState
        ) {
            viewModel.updateEventSubscribeStatus(event)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EventHead(
    modifier: Modifier = Modifier,
    event: Event,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CardAvatar(
            modifier = Modifier.fillMaxWidth(),
            avatar = event.avatar
        )
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            TextH1(text = event.eventName + event.id.toString())
            if (event.finished) {
                TextSecondary(
                    text = stringResource(R.string.event_finished),
                    color = colorDate
                )
            }
            TextSecondary(
                text = stringResource(
                    id = R.string.date_and_city_and_street,
                    event.date,
                    event.city,
                    event.street
                ),
                color = colorDate
            )
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(event.tags.size) {
                TagMedium(category = event.tags[it], enable = false) {}
            }
        }
    }
}
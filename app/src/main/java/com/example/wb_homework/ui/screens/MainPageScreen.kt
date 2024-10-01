package com.example.wb_homework.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.entities.Event
import com.example.wb_homework.R
import com.example.wb_homework.ui.screen_state.MainPageScreenState
import com.example.wb_homework.ui.state.ButtonState
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.update_ui_kit.CommunityCard
import com.example.wb_homework.ui.update_ui_kit.EventCardThin
import com.example.wb_homework.ui.update_ui_kit.EventCardWide
import com.example.wb_homework.ui.update_ui_kit.InitialScreen
import com.example.wb_homework.ui.update_ui_kit.MainButton
import com.example.wb_homework.ui.update_ui_kit.TagMedium
import com.example.wb_homework.ui.update_ui_kit.TextH2
import com.example.wb_homework.ui.utils.maxHeightInLazyRow
import com.example.wb_homework.viewmodels.MainPageViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MainPageScreen(
    modifier: Modifier = Modifier,
    viewModel: MainPageViewModel = koinViewModel(),
    onEventClickListener: (Int, Int) -> Unit,
    onCommunityClickListener: (Int) -> Unit,
    onProfileClickListener: () -> Unit,
) {
    val screenState = viewModel.getScreenStateFlow().collectAsStateWithLifecycle()
    when (val currentScreenState = screenState.value) {
        is MainPageScreenState.MainContent -> {
            MainPageContent(
                currentScreenState = currentScreenState,
                viewModel = viewModel,
                onEventClickListener = onEventClickListener,
                onCommunityClickListener = onCommunityClickListener,
                onProfileClickListener = onProfileClickListener
            )

        }

        is MainPageScreenState.Error -> {
            Column(
                modifier = modifier.fillMaxSize(),
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

        MainPageScreenState.Initial -> {
            InitialScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainPageContent(
    currentScreenState: MainPageScreenState.MainContent,
    viewModel: MainPageViewModel,
    onEventClickListener: (Int, Int) -> Unit,
    onCommunityClickListener: (Int) -> Unit,
    onProfileClickListener: () -> Unit,
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
                title = {},
                actions = {
                    IconButton(onClick = {
                        onProfileClickListener()
                    }) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ImageIcon(iconResId = R.drawable.head_user_icon)
                            ImageIcon(iconResId = R.drawable.body_user_icon)
                        }
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(40.dp),
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.maxHeightInLazyRow()
                    ) {
                        items(currentScreenState.events, key = { it.id }) { event ->
                            if (event.id == currentScreenState.events.first().id) {
                                Spacer(modifier = Modifier.size(16.dp))
                            }
                            EventCardWide(
                                event = event,
                                modifier = Modifier
                                    .width(320.dp)
                                    .clickable {
                                        onEventClickListener(
                                            event.id,
                                            event.communityId
                                        )
                                    },
                            )
                            if (event.id == currentScreenState.events.last().id) {
                                Spacer(modifier = Modifier.size(16.dp))
                            }
                        }
                    }
                }
            }

            item {
                UpcomingEvents(events = currentScreenState.comingEvents) { eventId, communityId ->
                    onEventClickListener(eventId, communityId)
                }
            }
            item {
                CommunityForTesters(
                   currentScreenState = currentScreenState,
                    onCommunityClickListener = onCommunityClickListener,
                    viewModel = viewModel
                )
            }
            item {
                TagSelection(
                    tags = currentScreenState.allTags,
                    selectedTag = currentScreenState.currentTags,
                    viewModel = viewModel,
                )
            }
            itemsIndexed(
                currentScreenState.eventsByTags, key = { _, item -> item.id }
            ) { index, event ->
                EventCardWide(
                    event = event,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickable {
                            onEventClickListener(
                                event.id,
                                event.communityId
                            )
                        }
                )
            }
        }
    }
}

@Composable
private fun UpcomingEvents(events: List<Event>, onEventClickListener: (Int, Int) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextH2(text = stringResource(R.string.coming_events))
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
private fun CommunityForTesters(
    currentScreenState: MainPageScreenState.MainContent,
    onCommunityClickListener: (Int) -> Unit,
    viewModel: MainPageViewModel
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextH2(text = stringResource(R.string.communities_for_testers))
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(currentScreenState.communities, key = { it.id }) {
                if (it.id == currentScreenState.communities.first().id) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
                CommunityCard(
                    community = it,
                    onClickCommunityCardListener = onCommunityClickListener,
                    onButtonClickListener = {
                        viewModel.updateMyCommunityList(
                            it,
                            currentScreenState.myCommunities
                        )
                    },
                    statusSubscribe = viewModel.isCommunityExists(
                        it,
                        currentScreenState.myCommunities
                    )
                )
                if (it.id == currentScreenState.communities.last().id) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TagSelection(
    tags: List<String>,
    selectedTag: List<String>,
    viewModel: MainPageViewModel
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        TextH2(text = stringResource(R.string.other_events))
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat(tags.size) {
                TagMedium(
                    category = tags[it],
                    selectedTag = selectedTag.contains(tags[it])
                ) {
                    viewModel.selectedTags(tags[it])
                }
            }
            TagMedium(
                category = stringResource(R.string.all_category),
                selectedTag = selectedTag.isEmpty()
            ) {
                if (selectedTag.isNotEmpty()) {
                    viewModel.clearSelectedTags()
                }
            }
        }
    }

}

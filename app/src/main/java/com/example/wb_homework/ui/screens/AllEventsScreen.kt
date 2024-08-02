package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.entities.Event
import com.example.wb_homework.R
import com.example.wb_homework.screen_states.ActiveEventsScreenState
import com.example.wb_homework.screen_states.AllEventsScreenState
import com.example.wb_homework.screen_states.TabIndexState
import com.example.wb_homework.ui.theme.PurpleDefault
import com.example.wb_homework.ui.theme.tabColor
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.EventCard
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.SearchView
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.viewmodels.AllEventsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AllEventsScreen(
    onAddPressed: () -> Unit,
    onEventCardClickListener: (Event) -> Unit,
    viewModel: AllEventsViewModel = koinViewModel(),
) {
    val allEventsScreenState = viewModel.getAllEventsListScreenStateFlow()
        .collectAsStateWithLifecycle()
    val activeEventsScreenState = viewModel.getActiveEventsScreenStateFlow()
        .collectAsStateWithLifecycle()
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
                    Subheading1(text = stringResource(id = R.string.meet))
                },
                navigationIcon = { Spacer(modifier = Modifier.width(24.dp)) },
                actions = {
                    IconButton(onClick = { onAddPressed() }) {
                        ImageIcon(
                            iconResId = R.drawable.plus_icon,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) { padding ->

        val tabIndexState = viewModel.getCurrentTabIndexFlow()
            .collectAsStateWithLifecycle()
        val titles = listOf(
            stringResource(id = R.string.all_meets),
            stringResource(id = R.string.active_meets)
        )
        when (val currentState = tabIndexState.value) {
            is TabIndexState.CurrentTabIndex -> {
                EventContent(
                    padding = padding,
                    tabIndexState = currentState,
                    titles = titles,
                    viewModel = viewModel,
                    allEventsScreenState = allEventsScreenState,
                    activeEventsScreenState = activeEventsScreenState
                ) { event ->
                    onEventCardClickListener(event)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EventContent(
    padding: PaddingValues,
    tabIndexState: TabIndexState.CurrentTabIndex,
    titles: List<String>,
    viewModel: AllEventsViewModel,
    allEventsScreenState: State<AllEventsScreenState>,
    activeEventsScreenState: State<ActiveEventsScreenState>,
    onEventCardClickListener: (Event) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 24.dp)
    ) {
        SearchView()
        Spacer(modifier = Modifier.width(16.dp))
        SecondaryTabRow(
            selectedTabIndex = tabIndexState.currentTabIndex,
            containerColor = Color.White,
            indicator = {
                SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabIndexState.currentTabIndex),
                    color = PurpleDefault
                )
            },
            divider = {
                HorizontalDivider(thickness = 0.dp, color = Color.White)
            }
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndexState.currentTabIndex == index,
                    onClick = {
                        viewModel.setCurrentTabIndex(index)
                    },
                    text = {
                        if (tabIndexState.currentTabIndex == index) {
                            BodyText1(text = title, color = PurpleDefault)

                        } else {
                            BodyText1(text = title, color = tabColor)
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        if (tabIndexState.currentTabIndex == FIRST_TAB) {
            AllEventColumns(eventsScreenState = allEventsScreenState) { event ->
                onEventCardClickListener(event)
            }
        } else {
            ActiveEventColumns(eventsScreenState = activeEventsScreenState) { event ->
                onEventCardClickListener(event)
            }
        }
    }
}

@Composable
private fun AllEventColumns(
    eventsScreenState: State<AllEventsScreenState>,
    onEventCardClickListener: (Event) -> Unit,
) {
    when (val currentState = eventsScreenState.value) {
        is AllEventsScreenState.AllEventList -> {
            ColumnForAllEvents(currentState = currentState) { event ->
                onEventCardClickListener(event)
            }
        }

        AllEventsScreenState.Initial -> {}
    }
}

@Composable
private fun ActiveEventColumns(
    eventsScreenState: State<ActiveEventsScreenState>,
    onEventCardClickListener: (Event) -> Unit,
) {
    when (val currentState = eventsScreenState.value) {
        is ActiveEventsScreenState.ActiveEventList -> {
            ColumnForActiveEvents(currentState = currentState) { event ->
                onEventCardClickListener(event)
            }
        }

        ActiveEventsScreenState.Initial -> {}
    }
}

@Composable
private fun ColumnForActiveEvents(
    currentState: ActiveEventsScreenState.ActiveEventList,
    onEventCardClickListener: (Event) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = currentState.activeEventList,
            key = { it.id }
        ) {
            EventCard(event = it) { event ->
                onEventCardClickListener(event)
            }
        }
    }
}

@Composable
private fun ColumnForAllEvents(
    currentState: AllEventsScreenState.AllEventList,
    onEventCardClickListener: (Event) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = currentState.allEventList,
            key = { it.id }
        ) {
            EventCard(event = it) { event ->
                onEventCardClickListener(event)
            }
        }
    }
}

const val FIRST_TAB = 0
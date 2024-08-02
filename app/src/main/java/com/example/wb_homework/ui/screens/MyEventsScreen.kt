package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.wb_homework.screen_states.PassedEventsScreenState
import com.example.wb_homework.screen_states.PlannedEventsScreenState
import com.example.wb_homework.screen_states.TabIndexState
import com.example.wb_homework.ui.theme.PurpleDefault
import com.example.wb_homework.ui.theme.tabColor
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.EventCard
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.viewmodels.MyEventsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEventsScreen(
    onBackPressed: () -> Unit,
    onEventCardClickListener: (Event) -> Unit,
    viewModel: MyEventsViewModel = koinViewModel(),
) {
    val plannedEventsScreenState = viewModel
        .getPlannedEventsListScreenStateFlow()
        .collectAsStateWithLifecycle()
    val passedEventsScreenState = viewModel
        .getPassedEventsListScreenStateFlow()
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
                    Subheading1(text = stringResource(id = R.string.my_meets))
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        ImageIcon(iconResId = R.drawable.back_icon, modifier = Modifier.size(24.dp))
                    }
                },
            )
        }
    ) { padding ->
        val tabIndexState = viewModel.getCurrentTabIndexFlow().collectAsStateWithLifecycle()
        val titles = listOf(
            stringResource(id = R.string.planned),
            stringResource(id = R.string.already_passed)
        )
        when (val currentState = tabIndexState.value) {
            is TabIndexState.CurrentTabIndex -> {
                MyEventsContent(
                    padding = padding,
                    tabIndexState = currentState,
                    titles = titles,
                    viewModel = viewModel,
                    plannedEventsScreenState = plannedEventsScreenState,
                    passedEventsScreenState = passedEventsScreenState
                ) { event ->
                    onEventCardClickListener(event)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyEventsContent(
    padding: PaddingValues,
    tabIndexState: TabIndexState.CurrentTabIndex,
    titles: List<String>,
    viewModel: MyEventsViewModel,
    plannedEventsScreenState: State<PlannedEventsScreenState>,
    passedEventsScreenState: State<PassedEventsScreenState>,
    onEventCardClickListener: (Event) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 22.dp)
    ) {
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
            PlannedEventColumns(screenState = plannedEventsScreenState) { event ->
                onEventCardClickListener(event)
            }
        } else {
            PassedEventColumns(screenState = passedEventsScreenState) { event ->
                onEventCardClickListener(event)
            }
        }
    }
}

@Composable
fun PlannedEventColumns(
    screenState: State<PlannedEventsScreenState>,
    onEventCardClickListener: (Event) -> Unit,
) {
    when (val currentState = screenState.value) {
        is PlannedEventsScreenState.PlannedEventsList -> {
            ColumnForPlannedEvent(currentState = currentState) { event ->
                onEventCardClickListener(event)
            }
        }

        PlannedEventsScreenState.Initial -> {}
    }
}

@Composable
fun PassedEventColumns(
    screenState: State<PassedEventsScreenState>,
    onEventCardClickListener: (Event) -> Unit,
) {
    when (val currentState = screenState.value) {
        is PassedEventsScreenState.PassedEventsList -> {
            ColumnForPassedEvent(currentState = currentState) { event ->
                onEventCardClickListener(event)
            }
        }

        PassedEventsScreenState.Initial -> {}
    }
}

@Composable
private fun ColumnForPassedEvent(
    currentState: PassedEventsScreenState.PassedEventsList,
    onEventCardClickListener: (Event) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = currentState.passedEventsList) {
            EventCard(
                event = it,
                onEventCardClickListener = { event ->
                    onEventCardClickListener(event)
                }
            )
        }
    }
}

@Composable
private fun ColumnForPlannedEvent(
    currentState: PlannedEventsScreenState.PlannedEventsList,
    onEventCardClickListener: (Event) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = currentState.plannedEventsList) {
            EventCard(
                event = it,
                onEventCardClickListener = { event ->
                    onEventCardClickListener(event)
                }
            )
        }
    }
}




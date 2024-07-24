package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.screen_states.AllEventsScreenState
import com.example.wb_homework.ui.theme.PurpleDefault
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.EventCard
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.SearchView
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.viewmodels.AllEventsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllEventsScreen(
    onAddPressed: () -> Unit,
    onEventCardClickListener: () -> Unit,
) {
    val viewModel: AllEventsViewModel = koinViewModel()
    val screenState = viewModel.getScreenState().collectAsState(AllEventsScreenState.Initial)
    viewModel.loadAllEvents()
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
        var state by remember { mutableIntStateOf(FIRST_TAB) }
        val titles = listOf(
            stringResource(id = R.string.all_meets),
            stringResource(id = R.string.active_meets)
        )

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            SearchView()
            Spacer(modifier = Modifier.width(16.dp))
            SecondaryTabRow(
                selectedTabIndex = state,
                containerColor = Color.White,
                indicator = {
                    SecondaryIndicator(
                        Modifier.tabIndicatorOffset(state),
                        color = PurpleDefault
                    )
                },
                divider = {
                    HorizontalDivider(thickness = 0.dp, color = Color.White)
                }
            ) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state == index,
                        onClick = {
                            state = index
                            if (state == FIRST_TAB) {
                                viewModel.loadAllEvents()
                            } else {
                                viewModel.loadActiveEvents()
                            }
                        },
                        text = {
                            if (state == index) {
                                BodyText1(text = title, color = PurpleDefault)

                            } else {
                                BodyText1(text = title, color = Color(0xFF666666))
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            EventColumns(
                screenState = screenState
            ) {
                onEventCardClickListener()
            }
        }
    }
}

@Composable
fun EventColumns(
    screenState: State<AllEventsScreenState>,
    onEventCardClickListener: () -> Unit,
) {
    when (val currentState = screenState.value) {
        is AllEventsScreenState.AllEventList -> {
            LazyColumn(modifier = Modifier.padding(bottom = 72.dp)) {
                items(
                    items = currentState.allEventList,
                    key = { it.id }
                ) {
                    EventCard(
                        event = it,
                        onEventCardClickListener = {
                            onEventCardClickListener()
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        is AllEventsScreenState.ActiveEventList -> {
            LazyColumn(modifier = Modifier.padding(bottom = 72.dp)) {
                items(
                    items = currentState.activeEventList,
                    key = { it.id }
                ) {
                    EventCard(
                        event = it,
                        onEventCardClickListener = {
                            onEventCardClickListener()
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
        AllEventsScreenState.Initial -> {}
    }
}

const val FIRST_TAB = 0


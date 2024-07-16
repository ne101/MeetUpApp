package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.domain.Event
import com.example.wb_homework.ui.theme.PurpleDefault
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.EventCard
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.Subheading1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEventsScreen(
    onBackPressed: () -> Unit,
    onEventCardClickListener: () -> Unit
) {
    val meets = mutableListOf<Event>().apply {
        repeat(20) {
            add(Event(id = it))
        }
    }

    val finishedEvents = mutableListOf<Event>().apply {
        repeat(20) {
            add(Event(id = it, finished = true))
        }
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
        var state by remember { mutableIntStateOf(0) }
        val titles = listOf("ЗАПЛАНИРОВАНО", "УЖЕ ПРОШЛИ")
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 22.dp)
        ) {
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
                        onClick = { state = index },
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

            if (state == 0) {
                LazyColumn(modifier = Modifier.padding(bottom = 72.dp)) {
                    items(items = meets) {
                        EventCard(
                            event = it,
                            onEventCardClickListener = {
                                onEventCardClickListener()
                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            } else {
                LazyColumn(modifier = Modifier.padding(bottom = 72.dp)) {
                    items(items = finishedEvents) {
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
        }
    }
}




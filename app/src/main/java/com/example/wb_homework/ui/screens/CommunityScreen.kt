package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.entities.Community
import com.example.wb_homework.R
import com.example.wb_homework.screen_states.CommunityScreenState
import com.example.wb_homework.ui.ui_kit.CommunityCard
import com.example.wb_homework.ui.ui_kit.SearchView
import com.example.wb_homework.ui.ui_kit.Subheading1
import com.example.wb_homework.viewmodels.CommunityViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun CommunityScreen(onClickCommunityCardListener: (Community) -> Unit) {
    val viewModel: CommunityViewModel = koinViewModel()
    val screenState = viewModel.getScreenStateFlow()
        .collectAsStateWithLifecycle()
    when (val currentState = screenState.value) {
        is CommunityScreenState.CommunityList -> {
            CommunityColumn(currentState.communityList) { community ->
                onClickCommunityCardListener(community)
            }
        }

        CommunityScreenState.Initial -> {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CommunityColumn(
    communities: List<Community>,
    onClickCommunityCardListener: (Community) -> Unit,
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
                    Subheading1(text = stringResource(id = R.string.Community))
                },
                navigationIcon = {
                    Spacer(modifier = Modifier.width(24.dp))
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
            SearchView()
            LazyColumn(
                modifier = Modifier.padding(bottom = 72.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = communities, key = { it.id }) {
                    CommunityCard(community = it) { community ->
                        onClickCommunityCardListener(community)
                    }
                }

            }
        }

    }
}
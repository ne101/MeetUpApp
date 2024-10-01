package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.example.wb_homework.R
import com.example.wb_homework.ui.screen_state.PersonScreenState
import com.example.wb_homework.ui.state.ButtonState
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.update_ui_kit.InitialScreen
import com.example.wb_homework.ui.update_ui_kit.MainButton
import com.example.wb_homework.ui.update_ui_kit.PersonCard
import com.example.wb_homework.ui.update_ui_kit.TextPrimary
import com.example.wb_homework.viewmodels.PersonViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun PeopleScreen(
    eventId: Int,
    title: String,
    onBackClickListener: () -> Unit,
    viewModel: PersonViewModel = koinViewModel(
        parameters = { parametersOf(eventId) }
    )
) {
    val screenState = viewModel.getScreenState().collectAsStateWithLifecycle()
    when (val currentScreenState = screenState.value) {
        is PersonScreenState.MainContent -> {
            PeopleContent(currentScreenState = currentScreenState, title = title) {
                onBackClickListener()
            }
        }

        is PersonScreenState.Error -> {
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

        PersonScreenState.Initial -> {
            InitialScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PeopleContent(
    currentScreenState: PersonScreenState.MainContent,
    title: String,
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
                        text = title,
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
                actions = { Spacer(modifier = Modifier.size(24.dp))}
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 16.dp),
            contentPadding = padding,
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(currentScreenState.persons, key = {it.id}) {
                PersonCard(person = it)
            }
        }
    }
}
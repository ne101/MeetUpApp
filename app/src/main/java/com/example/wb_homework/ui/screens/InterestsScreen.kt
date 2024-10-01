package com.example.wb_homework.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.wb_homework.R
import com.example.wb_homework.ui.screen_state.InterestsScreenState
import com.example.wb_homework.ui.state.ButtonState
import com.example.wb_homework.ui.theme.colorDate
import com.example.wb_homework.ui.update_ui_kit.InitialScreen
import com.example.wb_homework.ui.update_ui_kit.MainButton
import com.example.wb_homework.ui.update_ui_kit.TagBig
import com.example.wb_homework.ui.update_ui_kit.TextHuge
import com.example.wb_homework.ui.update_ui_kit.TextPrimary
import com.example.wb_homework.ui.update_ui_kit.TextRegular
import com.example.wb_homework.viewmodels.InterestsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun InterestsScreen(
    onLaunchMainScreenClickListener: () -> Unit,
    viewModel: InterestsViewModel = koinViewModel()
) {
    val screenState = viewModel.getScreenState().collectAsStateWithLifecycle()
    when (val currentScreenState = screenState.value) {
        is InterestsScreenState.MainContent -> {
            InterestsContent(
                currentScreenState = currentScreenState,
                viewModel = viewModel
            ) {
                onLaunchMainScreenClickListener()
            }
        }

        is InterestsScreenState.Error -> {
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

        InterestsScreenState.Initial -> {
            InitialScreen()
        }
    }
}

@Composable
private fun InterestsContent(
    currentScreenState: InterestsScreenState.MainContent,
    viewModel: InterestsViewModel,
    onLaunchMainScreenClickListener: () -> Unit,
) {
    Scaffold(containerColor = Color.White) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp)
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            InterestsHead()
            InterestsTags(
                tags = currentScreenState.tags,
                currentTags = currentScreenState.currentTags.toList(),
                viewModel = viewModel
            )
            InterestsButtons(
                buttonState = currentScreenState.mainButtonState,
                viewModel = viewModel,
                tags = currentScreenState.currentTags.toList()
            ) {
                onLaunchMainScreenClickListener()
            }
        }
    }

}

@Composable
private fun InterestsHead() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        TextHuge(text = stringResource(R.string.interests))
        TextRegular(text = stringResource(R.string.select_interests))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun InterestsTags(
    tags: List<String>,
    currentTags: List<String>,
    viewModel: InterestsViewModel
) {
    FlowRow(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(tags.size) {
            TagBig(
                category = tags[it],
                selectedTag = currentTags.contains(tags[it])
            ) {
                viewModel.updateTags(tags[it])
            }
        }
    }
}

@Composable
private fun InterestsButtons(
    buttonState: ButtonState,
    modifier: Modifier = Modifier,
    tags: List<String>,
    viewModel: InterestsViewModel,
    onLaunchMainScreenClickListener: () -> Unit,

    ) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        MainButton(
            text = stringResource(id = R.string.save),
            buttonState = buttonState
        ) {
            onLaunchMainScreenClickListener()
            viewModel.setTagsInDB(tags)
        }
        TextPrimary(
            text = stringResource(R.string.tell_later),
            modifier = Modifier.clickable {
                onLaunchMainScreenClickListener()
                viewModel.setTagsInDB(emptyList())
            },
            color = colorDate
        )
    }
}
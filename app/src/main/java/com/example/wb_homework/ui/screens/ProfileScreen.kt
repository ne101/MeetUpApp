package com.example.wb_homework.ui.screens

import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile
import com.example.wb_homework.R
import com.example.wb_homework.ui.custom_phone_field.CustomPhoneField
import com.example.wb_homework.ui.screen_state.ProfileScreenState
import com.example.wb_homework.ui.state.ButtonState
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.theme.redColor
import com.example.wb_homework.ui.theme.resetAvatarButtonColor
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.update_ui_kit.CommunityCardForProfileScreen
import com.example.wb_homework.ui.update_ui_kit.CustomTextField
import com.example.wb_homework.ui.update_ui_kit.EventCardThin
import com.example.wb_homework.ui.update_ui_kit.MainButton
import com.example.wb_homework.ui.update_ui_kit.TagBig
import com.example.wb_homework.ui.update_ui_kit.TagMedium
import com.example.wb_homework.ui.update_ui_kit.TagSmall
import com.example.wb_homework.ui.update_ui_kit.TextForMediumTag
import com.example.wb_homework.ui.update_ui_kit.TextH2
import com.example.wb_homework.ui.update_ui_kit.TextH4
import com.example.wb_homework.ui.update_ui_kit.TextHuge
import com.example.wb_homework.ui.update_ui_kit.TextPrimary
import com.example.wb_homework.ui.update_ui_kit.TextRegular
import com.example.wb_homework.ui.update_ui_kit.TextSecondary
import com.example.wb_homework.ui.update_ui_kit.ToggleButton
import com.example.wb_homework.ui.utils.maxHeightInLazyRow
import com.example.wb_homework.viewmodels.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ProfileScreen(
    viewModel: ProfileViewModel = koinViewModel(),
    onEventClickListener: (Int, Int) -> Unit,
    onCommunityClickListener: (Int) -> Unit,
    onBackClickListener: () -> Unit
) {
    val screenState = viewModel.getScreenState().collectAsStateWithLifecycle()
    when (val currentScreenState = screenState.value) {
        is ProfileScreenState.MainContent -> {
            ProfileContent(
                currentScreenState = currentScreenState,
                viewModel = viewModel,
                onEventClickListener = onEventClickListener,
                onCommunityClickListener = onCommunityClickListener,
                onBackClickListener = onBackClickListener
            )
        }

        is ProfileScreenState.EditContent -> {
            EditProfileContent(currentScreenState = currentScreenState, viewModel = viewModel)
            BackHandler {
                viewModel.canselEditState()
            }
        }

        is ProfileScreenState.EditTags -> {
            InterestsContent(currentScreenState = currentScreenState, viewModel = viewModel)
            BackHandler {
                viewModel.canselEditTagsState(currentScreenState.profile)
            }
        }

        is ProfileScreenState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = currentScreenState.message)
            }
        }

        ProfileScreenState.Initial -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = PurpleWB,
                    strokeWidth = 2.dp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileContent(
    currentScreenState: ProfileScreenState.MainContent,
    viewModel: ProfileViewModel,
    onEventClickListener: (Int, Int) -> Unit,
    onCommunityClickListener: (Int) -> Unit,
    onBackClickListener: () -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified
                ),
                title = {
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
                    IconButton(onClick = { viewModel.startEditState(currentScreenState.profile) }) {
                        ImageIcon(iconResId = R.drawable.share_icon)
                    }
                }
            )
        },
        bottomBar = {
            TextPrimary(
                text = stringResource(R.string.exit),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 28.dp)
                    .clickable { viewModel.logOut() },
                textAlign = TextAlign.Center
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(bottom = paddingValues.calculateBottomPadding())
                .statusBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(40.dp),
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(currentScreenState.profile.avatar)
                        .error(R.drawable.avatar)
                        .build(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 375.dp),
                    contentScale = ContentScale.Crop,
                )

            }

            item {
                ProfileHead(profile = currentScreenState.profile)
            }

            item {
                MyEvents(events = currentScreenState.profile.events) { eventId, communityId ->
                    onEventClickListener(eventId, communityId)
                }
            }

            item {
                MyCommunities(communities = currentScreenState.profile.communities) {
                    onCommunityClickListener(it)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditProfileContent(
    currentScreenState: ProfileScreenState.EditContent,
    viewModel: ProfileViewModel,
) {
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) {
            viewModel.updateProfileField("avatar", it.toString())
        }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified
                ),
                title = {
                },
                navigationIcon = {
                    IconButton(onClick = { viewModel.canselEditState() }) {
                        ImageIcon(
                            iconResId = R.drawable.cross_icon,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.updateProfile(currentScreenState.profile)
                        viewModel.setTagsInDB(currentScreenState.profile.tags.tags)
                    }) {
                        ImageIcon(
                            iconResId = R.drawable.check_icon,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },

                )
        },
        bottomBar = {
            TextPrimary(
                text = stringResource(R.string.delete_profile),
                color = redColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 28.dp)
                    .clickable { viewModel.logOut() },
                textAlign = TextAlign.Center
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .statusBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(40.dp),
        ) {
            item {
                Box {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(currentScreenState.profile.avatar)
                            .error(R.drawable.avatar)
                            .build(),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 375.dp),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .background(resetAvatarButtonColor, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        TextForMediumTag(
                            text = stringResource(R.string.change_photo),
                            color = Color.White,
                            modifier = Modifier.clickable {
                                launcher.launch("image/*")
                            }
                        )
                    }
                }

            }
            item {
                InputsInfo(currentScreenState, viewModel)
            }
            item {
                Interests(currentScreenState, viewModel)
            }
            item {
                SocialMedia(currentScreenState, viewModel)
            }
            item {
                Settings(currentScreenState, viewModel)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Interests(
    currentScreenState: ProfileScreenState.EditContent,
    viewModel: ProfileViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TextH2(text = stringResource(id = R.string.interests))
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(currentScreenState.profile.tags.tags.size) {
                TagMedium(
                    category = currentScreenState.profile.tags.tags[it],
                    enable = false,
                    selectedTag = true
                ) {}
            }
            TagMedium(category = stringResource(R.string.add_tag)) {
                viewModel.startEditTagsState(currentScreenState.profile)
            }
        }
    }
}

@Composable
private fun Settings(
    currentScreenState: ProfileScreenState.EditContent,
    viewModel: ProfileViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row {
            TextPrimary(
                text = stringResource(R.string.show_my_communities),
                color = PurpleWB,
                modifier = Modifier.weight(1f)
            )
            ToggleButton(checkStatus = currentScreenState.profile.showCommunities) {
                viewModel.updateProfileField(
                    "showCommunities",
                    currentScreenState.profile.showCommunities.not()
                )
            }
        }

        Row {
            TextPrimary(
                text = stringResource(R.string.show_my_events),
                color = PurpleWB,
                modifier = Modifier.weight(1f)
            )
            ToggleButton(checkStatus = currentScreenState.profile.showEvents) {
                viewModel.updateProfileField(
                    "showEvents",
                    currentScreenState.profile.showEvents.not()
                )
            }
        }
    }
}

@Composable
private fun SocialMedia(
    currentScreenState: ProfileScreenState.EditContent,
    viewModel: ProfileViewModel
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextH2(text = stringResource(R.string.social_media))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomTextField(
                text = currentScreenState.profile.habrName,
                textPlaceHolder = stringResource(R.string.habr)
            ) {
                viewModel.updateProfileField("habrName", it)
            }
            CustomTextField(
                text = currentScreenState.profile.telegramName,
                textPlaceHolder = stringResource(R.string.telegram)
            ) {
                viewModel.updateProfileField("telegramName", it)
            }
        }
    }
}

@Composable
private fun InputsInfo(
    currentScreenState: ProfileScreenState.EditContent,
    viewModel: ProfileViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomTextField(
            text = currentScreenState.profile.name,
            textPlaceHolder = stringResource(R.string.name_surname)
        ) { name ->
            viewModel.updateProfileField("name", name)
        }
        CustomPhoneField(
            inputPhoneNumber = currentScreenState.profile.phone
        ) { phone ->
            viewModel.updateProfileField("phone", phone)
        }
        CustomTextField(
            text = currentScreenState.profile.city,
            textPlaceHolder = stringResource(R.string.city)
        ) { city ->
            viewModel.updateProfileField("city", city)
        }
        CustomTextField(
            text = currentScreenState.profile.description,
            textPlaceHolder = stringResource(R.string.tell_about_you),
            maxLine = 4
        ) { description ->
            viewModel.updateProfileField("description", description)
        }
    }
}

@Composable
private fun ProfileInfo(
    profile: Profile,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextHuge(text = profile.name)
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            TextH4(text = profile.city)
            TextSecondary(text = profile.description)
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ProfileHead(
    profile: Profile,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileInfo(profile = profile)
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(profile.tags.tags.size) {
                TagSmall(category = profile.tags.tags[it])
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ImageIcon(iconResId = R.drawable.habr_icon)
            ImageIcon(iconResId = R.drawable.telegram_icon)
        }
    }
}

@Composable
private fun MyEvents(
    events: List<Event>,
    onEventClickListener: (Int, Int) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextH2(text = stringResource(R.string.my_events))
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
private fun MyCommunities(
    communities: List<Community>,
    onCommunityClickListener: (Int) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextH2(text = stringResource(R.string.my_communities))
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(communities, key = { it.id }) {
                if (it.id == communities.first().id) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
                CommunityCardForProfileScreen(
                    community = it,
                    onClickCommunityCardListener = onCommunityClickListener,
                )
                if (it.id == communities.last().id) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
private fun InterestsContent(
    currentScreenState: ProfileScreenState.EditTags,
    viewModel: ProfileViewModel,
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
                currentScreenState.currentTags,
                currentScreenState.profile,
                viewModel
            )
        }
    }

}

@Composable
private fun InterestsHead() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        TextHuge(text = stringResource(id = R.string.interests))
        TextRegular(text = stringResource(id = R.string.select_interests))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun InterestsTags(
    tags: List<String>,
    currentTags: List<String>,
    viewModel: ProfileViewModel
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
    tags: List<String>,
    profile: Profile,
    viewModel: ProfileViewModel,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        MainButton(text = stringResource(id = R.string.save), buttonState = ButtonState.Primary) {
            viewModel.updateTagsInEditState(profile, tags)
        }
    }
}
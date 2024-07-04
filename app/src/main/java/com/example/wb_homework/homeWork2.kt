package com.example.wb_homework

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.theme.ui_kit.CommunityCard
import com.example.wb_homework.domain.Community
import com.example.wb_homework.domain.Event
import com.example.wb_homework.ui.theme.ui_kit.AvatarBase
import com.example.wb_homework.ui.theme.ui_kit.AvatarMeet
import com.example.wb_homework.ui.theme.ui_kit.AvatarProfile
import com.example.wb_homework.ui.theme.ui_kit.BodyText1
import com.example.wb_homework.ui.theme.ui_kit.BodyText2
import com.example.wb_homework.ui.theme.ui_kit.EventCard
import com.example.wb_homework.ui.theme.ui_kit.EventCardFinished
import com.example.wb_homework.ui.theme.ui_kit.GhostDisableButton
import com.example.wb_homework.ui.theme.ui_kit.GhostHoverButton
import com.example.wb_homework.ui.theme.ui_kit.GhostInitialButton
import com.example.wb_homework.ui.theme.ui_kit.Heading1
import com.example.wb_homework.ui.theme.ui_kit.Heading2
import com.example.wb_homework.ui.theme.ui_kit.MetaData1
import com.example.wb_homework.ui.theme.ui_kit.MetaData2
import com.example.wb_homework.ui.theme.ui_kit.MetaData3
import com.example.wb_homework.ui.theme.ui_kit.MyChipRow
import com.example.wb_homework.ui.theme.ui_kit.PrimaryDisabledButton
import com.example.wb_homework.ui.theme.ui_kit.PrimaryHoverButton
import com.example.wb_homework.ui.theme.ui_kit.PrimaryInitialButton
import com.example.wb_homework.ui.theme.ui_kit.SearchView
import com.example.wb_homework.ui.theme.ui_kit.SecondaryDisableButton
import com.example.wb_homework.ui.theme.ui_kit.SecondaryHoverButton
import com.example.wb_homework.ui.theme.ui_kit.SecondaryInitialButton
import com.example.wb_homework.ui.theme.ui_kit.Subheading1
import com.example.wb_homework.ui.theme.ui_kit.Subheading2

@Composable
fun HomeWork2(modifier: Modifier = Modifier) {
    val state = remember {
        mutableStateOf(TextFieldValue(""))
    }
    LazyColumn() {
        item {
            AllButtons()
            Topography()
            AvatarBase()
            AvatarMeet()
            SearchView(state)
            MyChipRow(Event())
            EventCard(event = Event(), modifier = modifier)
            EventCardFinished(event = Event(), modifier = modifier)
            CommunityCard(community = Community(), modifier = modifier)
            OverlappingImageList(images = getImageList(), modifier = modifier)
            AvatarProfile(modifier = modifier, avatar = R.drawable.avatar)
        }
    }
}



fun getImageList(): List<Int> = mutableListOf<Int>().apply {
    repeat(20) {
        add(R.drawable.person_on_meet)
    }
}

@Composable
fun AllButtons() {
    PrimaryInitialButton()
    Spacer(modifier = Modifier.height(8.dp))
    SecondaryInitialButton()
    Spacer(modifier = Modifier.height(8.dp))
    GhostInitialButton()
    Spacer(modifier = Modifier.height(8.dp))
    PrimaryHoverButton()
    Spacer(modifier = Modifier.height(8.dp))
    SecondaryHoverButton()
    Spacer(modifier = Modifier.height(8.dp))
    GhostHoverButton()
    Spacer(modifier = Modifier.height(8.dp))
    PrimaryDisabledButton()
    Spacer(modifier = Modifier.height(8.dp))
    SecondaryDisableButton()
    Spacer(modifier = Modifier.height(8.dp))
    GhostDisableButton()
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun Topography(text: String = "The quick brown fox jumps over the lazy dog") {
    Column(modifier = Modifier.padding(16.dp)) {
        Heading1(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        Heading2(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        Subheading1(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        Subheading2(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        BodyText1(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        BodyText2(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        MetaData1(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        MetaData2(
            text = text
        )
        Spacer(modifier = Modifier.height(10.dp))

        MetaData3(
            text = text
        )
    }
}
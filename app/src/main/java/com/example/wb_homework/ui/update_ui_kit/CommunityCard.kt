package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Community
import com.example.wb_homework.ui.ui_kit.BodyText1


@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    community: Community,
    statusSubscribe: Boolean = false,
    onClickCommunityCardListener: (Int) -> Unit,
    onButtonClickListener: () -> Unit
) {
    Column(
        modifier = modifier.clickable { onClickCommunityCardListener(community.id) }.width(104.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CardAvatar(
            avatar = community.avatarCommunity,
            modifier = Modifier.height(104.dp)
        )
        BodyText1(text = community.communityName + community.id, maxLines = 1)
        CommunitySubscribeButton(statusSubscribe = statusSubscribe) {
            onButtonClickListener()
        }

    }
}

@Composable
fun CommunityCardForProfileScreen(
    modifier: Modifier = Modifier,
    community: Community,
    onClickCommunityCardListener: (Int) -> Unit,
) {
    Column(
        modifier = modifier.clickable { onClickCommunityCardListener(community.id) }.width(104.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CardAvatar(
            avatar = community.avatarCommunity,
            modifier = Modifier.height(104.dp)
        )
        BodyText1(text = community.communityName + community.id, maxLines = 1)
    }
}


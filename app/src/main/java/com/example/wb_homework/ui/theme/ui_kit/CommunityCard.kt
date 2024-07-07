package com.example.wb_homework.ui.theme.ui_kit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.domain.Community


@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    community: Community,
    onClickCommunityCardListener: () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardColors(
            contentColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
            containerColor = Color.White,
            disabledContainerColor = Color.White
        )
    ) {
        Column(modifier = Modifier.clickable { onClickCommunityCardListener() }) {
            Row(modifier = Modifier.fillMaxWidth()) {
                AvatarForCard(community.avatarCommunityId)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Spacer(modifier = Modifier.height(4.dp))
                    BodyText1(text = community.communityName)
                    Spacer(modifier = Modifier.height(4.dp))
                    MetaData1(text = community.countSubscribers, color = Color(0xFFADB5BD))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color(0xFFEDEDED))
        }
    }

}
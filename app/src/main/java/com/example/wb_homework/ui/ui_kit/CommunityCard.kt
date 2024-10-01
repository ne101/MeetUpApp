package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Community
import com.example.wb_homework.R


@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    community: Community,
    onClickCommunityCardListener: (Community) -> Unit
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
        Column(modifier = Modifier.clickable { onClickCommunityCardListener(community) }) {
            Row(modifier = Modifier.fillMaxWidth()) {
                AvatarForCard(community.avatarCommunity)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Spacer(modifier = Modifier.height(4.dp))
                    BodyText1(text = community.communityName + community.id.toString())
                    Spacer(modifier = Modifier.height(4.dp))
                    MetaData1(
                        text = stringResource(
                            id = R.string.count_subscribers,
                            community.personList.size.toString()
                        ),
                        color = Color(0xFFADB5BD)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color(0xFFEDEDED))
        }
    }

}
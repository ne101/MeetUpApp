package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.wb_homework.R
import com.example.wb_homework.ui.update_ui_kit.MorePeople
import com.example.wb_homework.ui.update_ui_kit.TextH2

@Composable
fun OverlappingImageList(
    modifier: Modifier = Modifier,
    event: Event,
    onPersonClickListener: (String) -> Unit
) {
    val text = if (event.finished) {
        stringResource(R.string.were_event)
    } else {
        stringResource(R.string.will_event)
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextH2(
            text = text
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy((-10).dp),
            modifier = Modifier.clickable { onPersonClickListener(text) }) {
            if (event.personList.size > VISIBLE_IMAGE_COUNT) {
                event.personList.take(VISIBLE_IMAGE_COUNT).forEachIndexed { index, person ->
                    AvatarForCard(
                        image = person.avatar,
                        modifier = Modifier.zIndex(index.toFloat())
                    )
                }

                MorePeople(
                    countPeople = event.personList.size - VISIBLE_IMAGE_COUNT,
                    modifier = Modifier.zIndex(VISIBLE_IMAGE_COUNT.toFloat())
                )
            } else {
                event.personList.take(VISIBLE_IMAGE_COUNT).forEachIndexed { index, person ->
                    AvatarForCard(
                        image = person.avatar,
                        modifier = Modifier.zIndex(index.toFloat())
                    )
                }
            }
        }
    }
}

@Composable
fun OverlappingImageList(
    modifier: Modifier = Modifier,
    community: Community
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextH2(text = "Подписаны")
        Row(horizontalArrangement = Arrangement.spacedBy((-10).dp)) {
            if (community.personList.size > VISIBLE_IMAGE_COUNT) {
                community.personList.take(VISIBLE_IMAGE_COUNT).forEachIndexed { index, person ->
                    AvatarForCard(
                        image = person.avatar,
                        modifier = Modifier.zIndex(index.toFloat())
                    )
                }
                MorePeople(
                    countPeople = community.personList.size - VISIBLE_IMAGE_COUNT,
                    modifier = Modifier.zIndex(VISIBLE_IMAGE_COUNT.toFloat())
                )
            } else {
                community.personList.take(VISIBLE_IMAGE_COUNT).forEachIndexed { index, person ->
                    AvatarForCard(
                        image = person.avatar,
                        modifier = Modifier.zIndex(index.toFloat())
                    )
                }
            }
        }
    }
}

const val VISIBLE_IMAGE_COUNT = 5


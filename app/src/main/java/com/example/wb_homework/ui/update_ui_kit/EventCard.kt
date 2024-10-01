package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Event
import com.example.wb_homework.R
import com.example.wb_homework.ui.theme.colorDate

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EventCardWide(
    modifier: Modifier = Modifier,
    event: Event,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CardAvatar(
            modifier = Modifier.height(180.dp),
            avatar = event.avatar
        )
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            TextH1(text = event.eventName + event.id.toString())
            if (event.finished) {
                TextSecondary(
                    text = stringResource(id = R.string.event_finished),
                    color = colorDate
                )
            }
            TextSecondary(
                text = stringResource(
                    id = R.string.date_and_city_and_street,
                    event.date,
                    event.city,
                    event.street
                ),
                color = colorDate
            )
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(event.tags.size) {
                TagSmall(category = event.tags[it])
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EventCardThin(
    modifier: Modifier = Modifier,
    event: Event,
    onClickEventCardListener: (Int, Int) -> Unit
) {
    Column(
        modifier = modifier
            .width(212.dp)
            .clickable {
                onClickEventCardListener(
                    event.id,
                    event.communityId
                )
            },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CardAvatar(
            modifier = Modifier.height(148.dp),
            avatar = event.avatar
        )
        TextH3(text = event.eventName + event.id)
        if (event.finished) {
            TextSecondary(
                text = stringResource(id = R.string.event_finished),
                color = colorDate
            )
        }
        TextSecondary(
            text = stringResource(
                id = R.string.date_and_city_and_street,
                event.date,
                event.city,
                event.street
            ),
            color = colorDate
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(event.tags.size) {
                TagSmall(category = event.tags[it])
            }
        }
    }
}

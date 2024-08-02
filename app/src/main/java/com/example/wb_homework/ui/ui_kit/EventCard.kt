package com.example.wb_homework.ui.ui_kit

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Event
import com.example.wb_homework.R

@SuppressLint("StringFormatMatches")
@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    event: Event,
    onEventCardClickListener: (Event) -> Unit
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardColors(
            contentColor = Color.Unspecified, disabledContentColor = Color.Unspecified,
            containerColor = Color.White, disabledContainerColor = Color.White
        )
    ) {
        Column(modifier = Modifier.clickable { onEventCardClickListener(event) }) {
            Row(modifier = Modifier.fillMaxWidth()) {
                AvatarForCard(event.avatar)
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 12.dp)
                ) {
                    BodyText1(text = event.eventName + event.id.toString())
                    Spacer(modifier = Modifier.height(2.dp))
                    MetaData1(
                        text = LocalContext.current.getString(
                            R.string.date_and_city,
                            event.date,
                            event.city
                        ),
                        color = Color(0xFFA4A4A4)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    MyChipRow(event = event)
                }
                if (event.finished) {
                    MetaData2(text = "Закончилась", color = Color(0xFFA4A4A4))
                }
            }
            HorizontalDivider(color = Color(0xFFEDEDED))
        }
    }

}
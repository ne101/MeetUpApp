package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.domain.Profile
import com.example.wb_homework.ui.theme.PhoneColor

@Composable
fun ProfileCard(
    profile: Profile,
    modifier: Modifier = Modifier,
    onProfileClickListener: () -> Unit
) {
    Card(
        modifier = modifier.clickable { onProfileClickListener() },
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardColors(
            contentColor = Color.Unspecified, disabledContentColor = Color.Unspecified,
            containerColor = Color.White, disabledContainerColor = Color.White
        )
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            ImageIcon(iconResId = profile.avatarResId, modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                BodyText1(text = profile.name)
                MetaData1(text = profile.phone, color = PhoneColor)
            }
            ImageIcon(iconResId = R.drawable.details_icon, modifier = Modifier.size(24.dp))

        }
    }
}
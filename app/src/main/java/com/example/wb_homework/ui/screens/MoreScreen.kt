package com.example.wb_homework.ui.screens

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.domain.Profile
import com.example.wb_homework.ui.theme.PhoneColor
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.MetaData1
import com.example.wb_homework.ui.ui_kit.ProfileCard
import com.example.wb_homework.ui.ui_kit.Subheading1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(
    onProfileClickListener: () -> Unit,
    onMyMeetsClickListener: () -> Unit,
    onThemeClickListener: () -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Color.White,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified

                ),
                title = { Subheading1(text = stringResource(id = R.string.more)) },
                navigationIcon = { Spacer(modifier = Modifier.width(24.dp))}
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
        ) {
            ProfileCard(Profile()) {
                onProfileClickListener()
            }
            Spacer(modifier = Modifier.height(16.dp))
            ElementCardForMoreScreen(
                icon = R.drawable.meet_icon,
                title = stringResource(id = R.string.my_meets)
            ) {
                onMyMeetsClickListener()
            }
            Spacer(modifier = Modifier.height(16.dp))
            ElementCardForMoreScreen(
                icon = R.drawable.sun_icon,
                title = "Тема"
            ) {
                onThemeClickListener()
            }
            Spacer(modifier = Modifier.height(8.dp))
            ElementCardForMoreScreen(
                icon = R.drawable.notification_icon,
                title = "Уведомления"
            ) {

            }
            Spacer(modifier = Modifier.height(8.dp))
            ElementCardForMoreScreen(
                icon = R.drawable.privacy_icon,
                title = "Безопасность"
            ) {

            }
            ElementCardForMoreScreen(
                icon = R.drawable.folder_icon,
                title = "Память и ресурсы"
            ) {

            }
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = Color(0xFFEDEDED)
            )
            ElementCardForMoreScreen(
                icon = R.drawable.help_icon,
                title = "Помощь"
            ) {

            }
            ElementCardForMoreScreen(
                icon = R.drawable.mail_icon,
                title = "Пригласи друга",
            ) {

            }
        }

    }
}

@Composable
fun ElementCardForMoreScreen(
    icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    onItemClickListener: () -> Unit
) {
    Card(
        modifier = modifier.clickable { onItemClickListener() },
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardColors(
            contentColor = Color.Unspecified, disabledContentColor = Color.Unspecified,
            containerColor = Color.White, disabledContainerColor = Color.White
        )
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)) {
            ImageIcon(iconResId = icon, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(8.dp))
            BodyText1(text = title, modifier = Modifier.weight(1f))
            ImageIcon(iconResId = R.drawable.details_icon, modifier = Modifier.size(24.dp))
        }
    }
}
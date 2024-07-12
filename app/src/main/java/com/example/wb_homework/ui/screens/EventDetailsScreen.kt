package com.example.wb_homework.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.ui_kit.OverlappingImageList
import com.example.wb_homework.R
import com.example.wb_homework.domain.Event
import com.example.wb_homework.ui.theme.GrayDefault
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.ui.ui_kit.MapImage
import com.example.wb_homework.ui.ui_kit.MetaData1
import com.example.wb_homework.ui.ui_kit.MyChipRow
import com.example.wb_homework.ui.ui_kit.PrimaryInitialButton
import com.example.wb_homework.ui.ui_kit.Subheading1

fun getImageList(): List<Int> = mutableListOf<Int>().apply {
    repeat(20) {
        add(R.drawable.person_on_meet)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailsScreen(
    onBackPressedClickListener: () -> Unit,
) {

    val event = Event()
    val mapUrl = "https://gas-kvas.com/grafic/uploads/posts/2024-01/gas-kvas-com-p-karta-mira-na-prozrachnom-fone-dlya-detei-3.jpg"
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
                title = {
                    Subheading1(text = "Developer meeting")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressedClickListener() }) {
                        ImageIcon(iconResId = R.drawable.back_icon)
                    }
                }
            )
        },

        ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 24.dp)
                .padding(bottom = 72.dp)
            ,

        ) {
            BodyText1(
                text = stringResource(
                    id = R.string.date_and_city_and_street,
                    event.data,
                    event.city,
                    event.street
                ),
                color = GrayDefault
            )
            Spacer(modifier = Modifier.height(2.dp))
            MyChipRow(event = event)
            Spacer(modifier = Modifier.height(12.dp))
            MapImage(mapUrl)
            Spacer(modifier = Modifier.height(20.dp))
            MetaData1(text = LoremIpsum().values.first().take(50))
            Spacer(modifier = Modifier.height(20.dp))
            OverlappingImageList(images = getImageList())
            Spacer(modifier = Modifier.weight(1f))
            PrimaryInitialButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Пойду на встречу!"
            )
        }

    }
}
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.ui.custom_code_field.CustomCodeField
import com.example.wb_homework.ui.ui_kit.BodyText2
import com.example.wb_homework.ui.ui_kit.GhostInitialButton
import com.example.wb_homework.ui.ui_kit.Heading2
import com.example.wb_homework.ui.ui_kit.ImageIcon
import com.example.wb_homework.viewmodels.AuthCodeViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthCodeScreen(
    phoneNumber: String,
    launchCreateProfileScreen: (String) -> Unit,
    viewModel: AuthCodeViewModel = koinViewModel()
) {
    val formattedPhone = StringBuilder(phoneNumber)
        .insert(3, " ")
        .insert(7, "-")
        .insert(10, "-")
    val ruCodeReg = "+7"
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

                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        ImageIcon(iconResId = R.drawable.back_icon)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    top = 80.dp,
                    end = 24.dp,
                    bottom = 80.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Heading2(
                text = stringResource(id = R.string.input_code),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            BodyText2(
                text = stringResource(id = R.string.send_code),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            BodyText2(
                text = stringResource(id = R.string.phone_number, formattedPhone),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(50.dp))
            CustomCodeField(modifier = Modifier.padding(horizontal = 24.dp)) {
                launchCreateProfileScreen("$ruCodeReg $formattedPhone")
            }
            Spacer(modifier = Modifier.height(70.dp))
            GhostInitialButton(
                onButtonClickListener = {},
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.recall_code)
            )
        }
    }

}


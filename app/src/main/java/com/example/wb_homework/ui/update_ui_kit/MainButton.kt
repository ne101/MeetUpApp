package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.state.ButtonState
import com.example.wb_homework.ui.theme.BackGroundWhite
import com.example.wb_homework.ui.theme.DisabledText
import com.example.wb_homework.ui.theme.LinearGradientPurpleBackGround
import com.example.wb_homework.ui.theme.LinearGradientWhiteBackGround
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.ui_kit.Subheading1

@Composable
fun MainButton(
    text: String,
    buttonState: ButtonState,
    onClick: () -> Unit
) {
    when (buttonState) {
        ButtonState.Loading -> {
            LoadingButton()
        }

        ButtonState.Primary -> {
            PrimaryButton(text = text) {
                onClick()
            }
        }

        ButtonState.Secondary -> {
            SecondaryButton(text = text) {
                onClick()
            }
        }
        ButtonState.Disabled -> {
            DisabledButton(text = text)
        }
    }

}

@Composable
private fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .background(brush = Brush.linearGradient(LinearGradientPurpleBackGround))
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        TextH3(text = text, color = Color.White)
    }
}

@Composable
private fun DisabledButton(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(BackGroundWhite)
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        TextH3(text = text, color = DisabledText)
    }
}

@Composable
private fun LoadingButton(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(brush = Brush.linearGradient(LinearGradientPurpleBackGround))
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(20.dp),
            color = Color.White,
            strokeWidth = 2.dp
        )
    }
}

@Composable
private fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .background(brush = Brush.linearGradient(LinearGradientWhiteBackGround))
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        TextH3(text = text, color = PurpleWB)
    }
}
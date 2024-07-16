package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.theme.GrayDefault
import com.example.wb_homework.ui.theme.OffWhite

@Composable
fun InputText(
    textPlaceHolder: String,
    necessarily: Boolean,
    onComplete: (Boolean) -> Unit,
) {

    var text by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            if (text.trim().isNotEmpty() && necessarily) {
                onComplete(true)
            } else {
                onComplete(false)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        decorationBox = {
            Box(
                Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(OffWhite)
                    .defaultMinSize(minHeight = 36.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (text.trim().isEmpty()) {
                    BodyText1(
                        text = textPlaceHolder,
                        color = GrayDefault
                    )
                }
                it()
            }
        }
    )
}
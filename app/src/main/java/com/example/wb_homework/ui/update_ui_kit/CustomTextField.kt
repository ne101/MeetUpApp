package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.wb_homework.ui.theme.BackGroundWhite
import com.example.wb_homework.ui.theme.InputTextColor
import com.example.wb_homework.ui.theme.PurpleWB
import com.example.wb_homework.ui.ui_kit.Subheading1

@Composable
fun CustomTextField(
    text: String,
    textPlaceHolder: String,
    maxLine: Int = 1,
    name: (String) -> Unit,
) {

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var focused by remember {
        mutableStateOf(true)
    }

    var currentText by remember {
        mutableStateOf(text)
    }

    BasicTextField(
        value = currentText,
        modifier = Modifier
            .focusRequester(focusRequester)
            .onFocusEvent { focused = !focused }
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                if (focused) {
                    PurpleWB
                } else {
                    Color.White
                },
                RoundedCornerShape(16.dp)
            ),
        onValueChange = {
            currentText = it
            name(currentText)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
            },
        ),
        maxLines = maxLine,
        textStyle = TextStyle(
            fontSize = 19.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = (-0.01).em,
            lineHeight = 23.sp
        ),
        decorationBox = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(BackGroundWhite)
                    .padding(horizontal = 12.dp, vertical = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (currentText.isEmpty()) {
                    TextRegular(
                        text = textPlaceHolder,
                        color = InputTextColor,
                        maxLines = maxLine,

                    )
                }
                it()
            }
        }
    )
}
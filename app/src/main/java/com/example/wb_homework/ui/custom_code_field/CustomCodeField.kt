package com.example.wb_homework.ui.custom_code_field

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.theme.NeutralLine
import com.example.wb_homework.ui.theme.PurpleDark
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.Heading1

@Composable
fun CustomCodeField(
    modifier: Modifier = Modifier,
    onComplete: (Boolean) -> Unit,
) {

    var code by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(CODE_LENGTH) { index ->
                Box(
                    modifier = Modifier
                        .size(
                            width = 32.dp,
                            height = 40.dp
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (index < code.length) {
                        Heading1(text = code[index].toString())
                    } else {
                        PlugGrayCircle()
                    }
                }
            }
        }
    }

    TextField(
        value = code,
        onValueChange = {
            if (it.length <= CODE_LENGTH && it.all { char -> char.isDigit() }) {
                code = it
                if (code.length == CODE_LENGTH) {
                    keyboardController?.hide()
                    onComplete(true)
                } else {
                    onComplete(false)
                }
            }
        },
        modifier = Modifier
            .focusRequester(focusRequester)
            .alpha(0f),
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}


@Composable
fun PlugGrayCircle() {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(
                color = NeutralLine,
                shape = CircleShape
            )
    )
}

const val CODE_LENGTH = 4


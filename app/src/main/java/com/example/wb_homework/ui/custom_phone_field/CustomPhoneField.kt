package com.example.wb_homework.ui.custom_phone_field


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PlatformImeOptions
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.wb_homework.R
import com.example.wb_homework.ui.theme.GrayDefault
import com.example.wb_homework.ui.theme.OffWhite
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.ImageIcon

@Composable
fun CustomPhoneField(
    onComplete: (Boolean) -> Unit,
    phoneNumber: (String) -> Unit
) {
    var currentPhoneNumber by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val mask = "000 000-00-00"
    val maskNumber = '0'
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(OffWhite)
                .padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageIcon(iconResId = R.drawable.russian_flag_icon)
            BodyText1(text = "+7", color = GrayDefault)
        }
        BasicTextField(
            value = currentPhoneNumber,
            onValueChange = { number ->
                currentPhoneNumber = number.take(
                    mask.count {
                        it == maskNumber
                    }
                )
                if (currentPhoneNumber.length == PHONE_LENGTH && currentPhoneNumber.isDigitsOnly()) {
                    keyboardController?.hide()
                    onComplete(true)
                    phoneNumber(currentPhoneNumber)
                } else {
                    onComplete(false)
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            visualTransformation = PhoneVisualTransformation(mask, maskNumber),
            decorationBox = {
                Box(
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(4.dp))
                        .background(OffWhite)
                        .defaultMinSize(minHeight = 36.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (currentPhoneNumber.isEmpty()) {
                        BodyText1(
                            text = mask,
                            color = GrayDefault,
                        )
                    }
                    it()
                }
            }

        )
    }
}
const val PHONE_LENGTH = 10
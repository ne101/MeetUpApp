package com.example.wb_homework.ui.custom_phone_field


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wb_homework.R
import com.example.wb_homework.ui.custom_code_field.CustomCodeField
import com.example.wb_homework.ui.theme.GrayDefault
import com.example.wb_homework.ui.theme.OffWhite
import com.example.wb_homework.ui.ui_kit.BodyText1
import com.example.wb_homework.ui.ui_kit.ImageIcon

@Composable
fun CustomPhoneField() {
    var phoneNumber by remember { mutableStateOf("") }
    val mask = "000 000-00-00"
    val maskNumber = '0'
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
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
            value = phoneNumber,
            onValueChange = { number ->
                phoneNumber = number.take(
                    mask.count {
                        it == maskNumber
                    }
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            visualTransformation = PhoneVisualTransformation(mask, maskNumber),
            decorationBox = {
                Box(
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(4.dp))
                        .background(OffWhite)
                        .defaultMinSize(minHeight = 40.dp, minWidth = 340.dp)
                        .padding(horizontal = 8.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (phoneNumber.isEmpty()) {
                        BodyText1(
                            text = mask,
                            color = GrayDefault
                        )
                    }
                    it()
                }
            }

        )
    }
}
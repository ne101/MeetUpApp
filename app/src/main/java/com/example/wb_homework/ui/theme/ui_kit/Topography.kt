package com.example.wb_homework.ui.theme.ui_kit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wb_homework.ui.theme.TextColor

@Composable
fun Heading1(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 32.sp,
        color = color,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun Heading2(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 24.sp,
        color = color,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun Subheading1(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}

@Composable
fun Subheading2(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}


@Composable
fun BodyText1(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}

@Composable
fun BodyText2(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = color,
        fontWeight = FontWeight.Normal,
        modifier = modifier
    )
}

@Composable
fun MetaData1(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 12.sp,
        color = color,
        fontWeight = FontWeight.Normal,
        modifier = modifier
    )
}

@Composable
fun MetaData2(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 10.sp,
        color = color,
        fontWeight = FontWeight.Normal,
        modifier = modifier
    )
}

@Composable
fun MetaData3(text: String, modifier: Modifier = Modifier, color: Color = TextColor) {
    Text(
        text = text,
        fontSize = 10.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}
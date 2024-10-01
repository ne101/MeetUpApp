package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.wb_homework.ui.theme.TextColor

@Composable
fun TextHuge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 49.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = (-0.05).em,
        lineHeight = 44.sp
    )
}

@Composable
fun TextRegular(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 19.sp,
        color = color,
        fontWeight = FontWeight.Normal,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = (-0.01).em,
        lineHeight = 23.sp
    )
}

@Composable
fun TextForBigTag(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 22.sp,
        color = color,
        fontWeight = FontWeight.Medium,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = (-0.01).em,
        lineHeight = 26.sp
    )
}

@Composable
fun TextSecondary(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = color,
        fontWeight = FontWeight.Medium,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em,
        lineHeight = 17.sp
    )
}

@Composable
fun TextForMediumTag(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = color,
        fontWeight = FontWeight.Medium,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em,
        lineHeight = 20.sp
    )
}

@Composable
fun TextH1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 32.sp,
        color = color,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em,
        lineHeight = 32.sp,
    )
}

@Composable
fun TextH2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 24.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em,
        lineHeight = 26.sp,
    )
}

@Composable
fun TextH3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em,
        lineHeight = 22.sp
    )
}

@Composable
fun TextH4(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em,
        lineHeight = 22.sp
    )
}

@Composable
fun TextPrimary(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = color,
        fontWeight = FontWeight.Medium,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = (-0.01).em,
        lineHeight = 22.sp
    )
}




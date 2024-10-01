package com.example.wb_homework.ui.ui_kit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.wb_homework.ui.theme.TextColor

@Composable
fun Heading1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
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
        letterSpacing = 0.001.em
    )
}

@Composable
fun Heading2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
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
        letterSpacing = 0.001.em
    )
}

@Composable
fun Subheading1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
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
        letterSpacing = 0.001.em
    )
}

@Composable
fun Subheading2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em,

    )
}


@Composable
fun BodyText1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
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
        letterSpacing = 0.001.em
    )
}

@Composable
fun BodyText2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
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
fun MetaData1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 12.sp,
        color = color,
        fontWeight = FontWeight.Normal,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em
    )
}

@Composable
fun MetaData2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 10.sp,
        color = color,
        fontWeight = FontWeight.Normal,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em
    )
}

@Composable
fun MetaData3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = TextColor,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        fontSize = 10.sp,
        color = color,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        letterSpacing = 0.001.em
    )
}
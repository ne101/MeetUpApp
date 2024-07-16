package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.wb_homework.ui.theme.PurpleDark
import com.example.wb_homework.ui.theme.PurpleDefault

@Composable
fun PrimaryInitialButton(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    text: String = "Button",
    onButtonClickListener: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable {onButtonClickListener()}
            .background(PurpleDefault)
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center

    ) {
        Subheading2(text = text, color = textColor)
    }
}

@Composable
fun SecondaryInitialButton(
    modifier: Modifier = Modifier,
    textColor: Color = PurpleDefault,
    text: String = "Button",
    onButtonClickListener: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable {onButtonClickListener()}
            .background(Color.White)
            .border(2.dp, PurpleDark, RoundedCornerShape(30.dp))
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center

    ) {
        Subheading2(text = text, color = textColor)
    }
}

@Composable
fun GhostInitialButton(
    modifier: Modifier = Modifier,
    textColor: Color = PurpleDefault,
    text: String = "Button",
    onButtonClickListener: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable {onButtonClickListener()}
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center
    ) {
        Subheading2(text = text, color = textColor)
    }
}

@Composable
fun PrimaryHoverButton(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    text: String = "Button",
    onButtonClickListener: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(interactionSource = interactionSource, indication = null) {
                onButtonClickListener()
            }
            .background(if (isPressed) PurpleDark else PurpleDefault)
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center

    ) {
        Subheading2(text = text, color = textColor)
    }
}

@Composable
fun SecondaryHoverButton(modifier: Modifier = Modifier, text: String = "Button") {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var currentTextColor: Color
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White)
            .clickable(interactionSource = interactionSource, indication = null) {}
            .border(2.dp, if (isPressed) PurpleDark else PurpleDefault, RoundedCornerShape(30.dp))
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center


    ) {
        currentTextColor = if (isPressed) {
            PurpleDark
        } else {
            PurpleDefault
        }
        Subheading2(text = text, color = currentTextColor)
    }
}

@Composable
fun GhostHoverButton(modifier: Modifier = Modifier, text: String = "Button") {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var currentTextColor: Color
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(interactionSource = interactionSource, indication = null) {}
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center
    ) {
        currentTextColor = if (isPressed) {
            PurpleDark
        } else {
            PurpleDefault
        }
        Subheading2(text = text, color = currentTextColor)
    }
}

@Composable
fun PrimaryDisabledButton(
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    text: String = "Button",
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(enabled = false) {}
            .background(PurpleDefault.copy(alpha = 0.5f))
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center

    ) {
        Subheading2(text = text, color = textColor)
    }
}

@Composable
fun SecondaryDisableButton(
    modifier: Modifier = Modifier,
    textColor: Color = PurpleDefault,
    text: String = "Button",
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(enabled = false) {}
            .background(Color.White.copy(alpha = 0.5f))
            .border(2.dp, PurpleDark.copy(alpha = 0.5f), RoundedCornerShape(30.dp))
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center
    ) {
        Subheading2(text = text, color = textColor.copy(alpha = 0.5f))
    }
}

@Composable
fun GhostDisableButton(
    modifier: Modifier = Modifier,
    textColor: Color = PurpleDefault,
    text: String = "Button",
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(enabled = false) {}
            .background(Color.White.copy(alpha = 0.5f))
            .padding(vertical = 12.dp, horizontal = 48.dp),
        contentAlignment = Alignment.Center
    ) {
        Subheading2(text = text, color = textColor.copy(alpha = 0.5f))
    }
}

@Composable
fun ButtonWithIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    verticalPadding: Dp,
    horizontalPadding: Dp,

    ) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .clickable {}
            .background(Color.White)
            .border(2.dp, PurpleDefault, RoundedCornerShape(25.dp))
            .padding(vertical = verticalPadding, horizontal = horizontalPadding),
        contentAlignment = Alignment.Center


    ) {
        ImageIcon(iconResId = icon, modifier = Modifier.size(20.dp))
    }
}
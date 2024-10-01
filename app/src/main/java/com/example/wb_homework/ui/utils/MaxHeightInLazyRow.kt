package com.example.wb_homework.ui.utils

import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun Modifier.maxHeightInLazyRow(): Modifier {
    val dpSaver = Saver<Dp, Float>(
        save = { it.value },
        restore = { Dp(it) }
    )
    val density = LocalDensity.current
    var maxHeight by rememberSaveable(stateSaver = dpSaver) { mutableStateOf(0.dp) }
    return this
        .onGloballyPositioned { coordinates ->
            val heightPx = coordinates.size.height
            val heightDp = with(density) { heightPx.toDp() }
            if (heightDp > maxHeight) {
                maxHeight = heightDp
            }
        }
        .heightIn(min = maxHeight)
}
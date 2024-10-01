package com.example.wb_homework.ui.ui_kit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.wb_homework.R
import com.example.wb_homework.ui.theme.GrayDefault
import com.example.wb_homework.ui.theme.OffWhite


@Composable
fun SearchView() {
    val state = remember {
        mutableStateOf(TextFieldValue(""))
    }
    TextField(
        value = state.value,
        onValueChange = { value -> state.value = value },
        modifier = Modifier
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 6.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = { state.value = TextFieldValue("") }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 6.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        placeholder = { BodyText1(text = stringResource(R.string.search), color = GrayDefault) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = GrayDefault,
            focusedContainerColor = OffWhite,
            unfocusedContainerColor = OffWhite,
            disabledContainerColor = OffWhite,
            cursorColor = GrayDefault,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = GrayDefault,
            unfocusedLeadingIconColor = GrayDefault,
            disabledLeadingIconColor = GrayDefault,
            focusedTrailingIconColor = GrayDefault,
            unfocusedTrailingIconColor = GrayDefault,
        )
    )
}

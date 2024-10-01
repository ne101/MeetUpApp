package com.example.wb_homework.ui.update_ui_kit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Person
import com.example.wb_homework.ui.ui_kit.Subheading1

@Composable
fun PersonCard(
    modifier: Modifier = Modifier,
    person: Person,
) {
    Column(
        modifier = modifier.width(104.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        AvatarForPerson(
            avatar = person.avatar,
            modifier = Modifier.height(104.dp)
        )
        Subheading1(text = person.name + person.id)
        TagSmall(category = person.tags.first())
    }
}
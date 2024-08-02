package com.example.data.mapper

import com.example.data.local_data_base.EventTable
import com.example.data.local_data_base.ProfileTable
import com.example.domain.entities.Event
import com.example.domain.entities.Profile

class Mapper {
    fun mapProfileToProfileTable(profile: Profile): ProfileTable = ProfileTable(
        name = profile.name,
        secondName = profile.secondName,
        phone = profile.phone,
        avatar = profile.avatar.toString(),
        events = profile.events.map { mapEventToEventTable(it) }
    )

    fun mapEventToEventTable(event: Event): EventTable = EventTable(
        id = event.id,
        eventName = event.eventName,
        date = event.date,
        city = event.city,
        street = event.street,
        avatar = event.avatar,
        chips = event.chips,
        finished = event.finished,
        imageList = event.imageList,
        mapUrl = event.mapUrl
    )

    fun mapProfileTableToProfile(profileTable: ProfileTable): Profile = Profile(
        name = profileTable.name,
        secondName = profileTable.secondName,
        phone = profileTable.phone,
        avatar = profileTable.avatar,
        events = profileTable.events.map { mapEventTableToEvent(it) }
    )

    fun mapEventTableToEvent(eventTable: EventTable): Event = Event(
        id = eventTable.id,
        eventName = eventTable.eventName,
        date = eventTable.date,
        city = eventTable.city,
        street = eventTable.street,
        avatar = eventTable.avatar,
        chips = eventTable.chips,
        finished = eventTable.finished,
        imageList = eventTable.imageList,
        mapUrl = eventTable.mapUrl
    )
}
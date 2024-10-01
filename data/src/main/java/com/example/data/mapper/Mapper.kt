package com.example.data.mapper

import com.example.data.local_data_base.table.CommunityTable
import com.example.data.local_data_base.table.EventTable
import com.example.data.local_data_base.table.ProfileTable
import com.example.data.local_data_base.table.TagsTable
import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Profile
import com.example.domain.entities.Tags

class Mapper {
    fun mapProfileToProfileTable(profile: Profile): ProfileTable = ProfileTable(
        name = profile.name,
        secondName = profile.secondName,
        phone = profile.phone,
        avatar = profile.avatar,
        events = profile.events.map { mapEventToEventTable(it) },
        communities = profile.communities.map { mapCommunityToCommunityTable(it) },
        tags = tagsToTagsTable(profile.tags),
        description = profile.description,
        habrName = profile.habrName,
        telegramName = profile.telegramName,
        showEvents = profile.showEvents,
        showCommunities = profile.showCommunities,
        city = profile.city
    )

    fun mapEventToEventTable(event: Event): EventTable = EventTable(
        id = event.id,
        eventName = event.eventName,
        date = event.date,
        city = event.city,
        street = event.street,
        avatar = event.avatar,
        tags = event.tags,
        finished = event.finished,
        communityId = event.communityId
    )

    fun mapProfileTableToProfile(profileTable: ProfileTable): Profile = Profile(
        name = profileTable.name,
        secondName = profileTable.secondName,
        phone = profileTable.phone,
        avatar = profileTable.avatar,
        events = profileTable.events.map { mapEventTableToEvent(it) },
        communities = profileTable.communities.map { mapCommunityTableToCommunity(it) },
        tags = tagsTableToTags(profileTable.tags) ?: Tags(emptyList()),
        description = profileTable.description,
        habrName = profileTable.habrName,
        telegramName = profileTable.telegramName,
        showEvents = profileTable.showEvents,
        showCommunities = profileTable.showCommunities,
        city = profileTable.city
    )

    fun mapEventTableToEvent(eventTable: EventTable): Event = Event(
        id = eventTable.id,
        eventName = eventTable.eventName,
        date = eventTable.date,
        city = eventTable.city,
        street = eventTable.street,
        avatar = eventTable.avatar,
        tags = eventTable.tags,
        finished = eventTable.finished,
        communityId = eventTable.communityId
    )

    fun mapCommunityToCommunityTable(community: Community) = CommunityTable(
        id = community.id,
        communityName = community.communityName,
        avatarCommunity = community.avatarCommunity,
        tags = community.tags

    )

    fun mapCommunityTableToCommunity(communityTable: CommunityTable) = Community(
        id = communityTable.id,
        communityName = communityTable.communityName,
        avatarCommunity = communityTable.avatarCommunity,
        tags = communityTable.tags
    )

    fun tagsToTagsTable(tags: Tags) = TagsTable(
        tags = tags.tags
    )

    fun tagsTableToTags(tagsTable: TagsTable?) = tagsTable?.let {
        Tags(
            tags = it.tags
        )
    }
}
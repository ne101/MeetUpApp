package com.example.data.repository_impl

import com.example.data.local_data_base.dao.TagsDao
import com.example.data.mapper.Mapper
import com.example.domain.entities.Tags
import com.example.domain.repository.TagsRepository
import kotlinx.coroutines.flow.map

internal class TagsRepositoryImpl(
    private val tagsDao: TagsDao,
    private val mapper: Mapper
) : TagsRepository{

    override fun getMyTags() = tagsDao.getMyTags().map {
        mapper.tagsTableToTags(it) ?: Tags(emptyList())
    }

    override suspend fun setMyTags(tags: List<String>) {
        tagsDao.setMyTags(mapper.tagsToTagsTable(Tags(tags)))
    }
}
package domain.mockStub

import com.example.domain.entities.Community
import com.example.domain.entities.Event
import com.example.domain.entities.Tags
import kotlin.random.Random

internal class MockDataStub {
    val communityList = mutableListOf<Community>().apply {
        repeat(5) {
            add(
                Community(
                    id = it,
                    tags = getRandomTagsForCommunity(Tags())
                )
            )
        }
    }.toList()

    val eventList = mutableListOf<Event>().apply {
        repeat(15) {
            add(
                Event(
                    id = it,
                    communityId = Random.nextInt(0, communityList.size),
                    finished = it % 2 != 0,
                    tags = getRandomTagsForEvent(Tags())
                )
            )
        }
    }.toList()

    val tags = Tags()

    private fun getRandomTagsForEvent(tags: Tags): List<String> {
        return mutableSetOf<String>().apply {
            repeat(3) {
                add(tags.tags.random())
            }
        }.toList()
    }

    private fun getRandomTagsForCommunity(tags: Tags): List<String> {
        return mutableSetOf<String>().apply {
            repeat(5) {
                add(tags.tags.random())
            }
        }.toList()
    }
}
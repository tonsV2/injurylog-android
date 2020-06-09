package dk.fitfit.injurylog.repository

import android.util.Log
import androidx.lifecycle.LiveData
import dk.fitfit.injurylog.api.service.TagService
import dk.fitfit.injurylog.db.dao.TagDao
import dk.fitfit.injurylog.db.model.Tag

private const val TAG = "TagRepository"

class TagRepository(private val tagService: TagService, private val tagDao: TagDao) {

    suspend fun update() {
        val lastUpdate = tagDao.getLastUpdate()

        val tagResponses = tagService.getUpdates(lastUpdate)

        Log.d(TAG, "Updates retrieved: ${tagResponses.size}")

        val tags = tagResponses.map {
            Tag(it.name, it.updated, it.created, it.id)
        }

        tagDao.insert(tags)
    }

    fun findAll(): LiveData<List<Tag>> = tagDao.findAll()
}

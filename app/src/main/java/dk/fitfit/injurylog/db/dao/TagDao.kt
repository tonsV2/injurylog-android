package dk.fitfit.injurylog.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import dk.fitfit.injurylog.db.model.Tag

@Dao
interface TagDao : UpdatableDao<Tag> {
    @Query("select * from Tag order by updated desc")
    fun findAll(): LiveData<List<Tag>>

    @Query("select max(updated) from Tag")
    override fun getLastUpdate(): Long
}

package dk.fitfit.injurylog.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import dk.fitfit.injurylog.db.model.ImageReference

@Dao
interface ImageReferenceDao : UpdatableDao<ImageReference> {
    @Query("select * from ImageReference order by updated desc")
    fun findAll(): LiveData<List<ImageReference>>

    @Query("select max(updated) from ImageReference")
    override fun getLastUpdate(): Long
}

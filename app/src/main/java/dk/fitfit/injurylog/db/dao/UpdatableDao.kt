package dk.fitfit.injurylog.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import dk.fitfit.injurylog.db.model.UpdatableEntity

interface UpdatableDao<T : UpdatableEntity> {
    @Insert(onConflict = REPLACE)
    fun insert(entities: List<T>)

    @Insert(onConflict = REPLACE)
    fun insert(entity: T)

    fun getLastUpdate(): Long
}

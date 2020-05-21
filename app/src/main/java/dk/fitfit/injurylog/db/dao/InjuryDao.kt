package dk.fitfit.injurylog.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import dk.fitfit.injurylog.db.model.Injury
import dk.fitfit.injurylog.db.model.InjuryWithTags

@Dao
interface InjuryDao : UpdatableDao<Injury> {
    @Transaction
    @Query("select * from Injury order by updated desc")
    fun findAll(): LiveData<List<InjuryWithTags>>

    @Query("select max(updated) from Injury")
    override fun getLastUpdate(): Long
}

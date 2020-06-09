package dk.fitfit.injurylog.db.dao

import androidx.room.Dao
import androidx.room.Insert
import dk.fitfit.injurylog.db.model.InjuryTagsCrossReference

@Dao
interface InjuryTagsCrossReferenceDao {
    @Insert
    fun insert(entities: List<InjuryTagsCrossReference>)
}

package dk.fitfit.injurylog.db.dao

import androidx.room.Dao
import androidx.room.Insert
import dk.fitfit.injurylog.db.model.InjuryImageReferencesCrossReference

@Dao
interface InjuryImageReferencesCrossReferenceDao {
    @Insert
    fun insert(entities: List<InjuryImageReferencesCrossReference>)
}

package dk.fitfit.injurylog.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dk.fitfit.injurylog.db.dao.InjuryDao
import dk.fitfit.injurylog.db.model.Injury
import dk.fitfit.injurylog.db.model.InjuryTagsCrossRef
import dk.fitfit.injurylog.db.model.Tag

@Database(entities = [Injury::class, Tag::class, InjuryTagsCrossRef::class], version = 1)
@TypeConverters(MyTypeConverters::class)
abstract class InjuryLogDatabase : RoomDatabase() {
    abstract fun injuryDao(): InjuryDao
}

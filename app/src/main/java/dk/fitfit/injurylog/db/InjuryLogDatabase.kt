package dk.fitfit.injurylog.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dk.fitfit.injurylog.db.dao.*
import dk.fitfit.injurylog.db.model.*

@Database(entities = [Injury::class, Tag::class, InjuryTagsCrossReference::class, ImageReference::class, InjuryImageReferencesCrossReference::class], version = 1)
@TypeConverters(MyTypeConverters::class)
abstract class InjuryLogDatabase : RoomDatabase() {
    abstract fun injuryDao(): InjuryDao
    abstract fun tagDao(): TagDao
    abstract fun injuryTagsCrossReferenceDao(): InjuryTagsCrossReferenceDao
    abstract fun imageReferenceDao(): ImageReferenceDao
    abstract fun injuryImageReferencesCrossRefDao(): InjuryImageReferencesCrossReferenceDao
}

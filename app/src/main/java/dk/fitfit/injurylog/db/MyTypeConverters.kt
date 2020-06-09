package dk.fitfit.injurylog.db

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class MyTypeConverters {
    @TypeConverter
    fun fromLocalDateTime(localDateTime: LocalDateTime): Long = localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli()

    @TypeConverter
    fun toLocalDateTime(millisSinceEpoch: Long): LocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(millisSinceEpoch), ZoneOffset.UTC)
}

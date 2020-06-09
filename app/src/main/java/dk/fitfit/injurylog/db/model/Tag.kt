package dk.fitfit.injurylog.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Tag(
    val name: String,
    override val updated: LocalDateTime,
    val created: LocalDateTime,
    @PrimaryKey(autoGenerate = false)
    val id: Long
) : UpdatableEntity

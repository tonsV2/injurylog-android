package dk.fitfit.injurylog.db.model

import androidx.room.*
import java.time.LocalDateTime
import java.time.ZoneOffset

@Entity
data class Tag(
    val name: String,
    override val updated: Long?,
    val created: LocalDateTime,
    @PrimaryKey(autoGenerate = false) val id: Long
) : UpdatableEntity

@Entity
data class Injury(
    val description: String,
    val occurredAt: LocalDateTime,
    val loggedAt: LocalDateTime,
    override val updated: Long?,
    val created: LocalDateTime,
    @PrimaryKey(autoGenerate = false) val id: Long
) : UpdatableEntity

@Entity(
    primaryKeys = ["injuryId", "tagId"],
    indices = [Index("injuryId"), Index("tagId")],
    foreignKeys = [
        ForeignKey(
            entity = Injury::class,
            parentColumns = ["id"],
            childColumns = ["injuryId"]
        ),
        ForeignKey(
            entity = Tag::class,
            childColumns = ["tagId"],
            parentColumns = ["id"]
        )
    ]
)
data class InjuryTagsCrossRef(
    val injuryId: Long,
    val tagId: Long
)

data class InjuryWithTags(
    @Embedded
    val injury: Injury,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(InjuryTagsCrossRef::class, parentColumn = "tagId", entityColumn = "injuryId")
    )
    val tags: List<Tag>
)

fun LocalDateTime.toEpochMilli() = this.toInstant(ZoneOffset.UTC).toEpochMilli()

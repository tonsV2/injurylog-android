package dk.fitfit.injurylog.db.model

import androidx.room.*
import java.time.LocalDateTime

@Entity
data class Injury(
    val description: String,
    val occurredAt: LocalDateTime,
    val loggedAt: LocalDateTime,
    override val updated: LocalDateTime,
    val created: LocalDateTime,
    @PrimaryKey(autoGenerate = false)
    val id: Long
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
data class InjuryTagsCrossReference(
    val injuryId: Long,
    val tagId: Long
)

data class InjuryWithTags(
    @Embedded
    val injury: Injury,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(InjuryTagsCrossReference::class, parentColumn = "injuryId", entityColumn = "tagId")
    )
    val tags: List<Tag>
)

@Entity(
    primaryKeys = ["injuryId", "imageReferenceId"],
    indices = [Index("injuryId"), Index("imageReferenceId")],
    foreignKeys = [
        ForeignKey(
            entity = Injury::class,
            parentColumns = ["id"],
            childColumns = ["injuryId"]
        ),
        ForeignKey(
            entity = ImageReference::class,
            childColumns = ["imageReferenceId"],
            parentColumns = ["id"]
        )
    ]
)
data class InjuryImageReferencesCrossReference(
    val injuryId: Long,
    val imageReferenceId: Long
)

@Entity
data class ImageReference(
    override val updated: LocalDateTime,
    @PrimaryKey(autoGenerate = false)
    val id: Long
) : UpdatableEntity

data class InjuryWithTagsAndImageReferences(
    @Embedded
    val injury: Injury,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(InjuryTagsCrossReference::class, parentColumn = "tagId", entityColumn = "injuryId")
    )
    val tags: List<Tag>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(InjuryImageReferencesCrossReference::class, parentColumn = "imageReferenceId", entityColumn = "injuryId")
    )
    val imageReferences: List<ImageReference>
)

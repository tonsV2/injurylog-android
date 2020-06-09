package dk.fitfit.injurylog.db.model

import java.time.LocalDateTime

interface UpdatableEntity {
    val updated: LocalDateTime
}

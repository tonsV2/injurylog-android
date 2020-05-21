package dk.fitfit.injurylog.repository

import androidx.lifecycle.LiveData
import dk.fitfit.injurylog.api.service.InjuryService
import dk.fitfit.injurylog.db.dao.InjuryDao
import dk.fitfit.injurylog.db.model.Injury
import dk.fitfit.injurylog.db.model.InjuryWithTags
import dk.fitfit.injurylog.db.model.toEpochMilli

class InjuryRepository(private val injuryService: InjuryService, private val injuryDao: InjuryDao) {

    suspend fun update() {
        val lastUpdate = injuryDao.getLastUpdate()

        val injuryResponses = injuryService.getInjuries(lastUpdate)

        val injuries = injuryResponses.map {
            Injury(it.description, it.occurredAt, it.loggedAt, it.updated.toEpochMilli(), it.created, it.id)
        }

        injuryDao.insert(injuries)
    }

    fun findAll(): LiveData<List<InjuryWithTags>> = injuryDao.findAll()
}

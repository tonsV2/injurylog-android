package dk.fitfit.injurylog.api.service

import dk.fitfit.injurylog.dto.InjuryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface InjuryService {
    @GET("/injuries")
    suspend fun getInjuries(@Query("updatedTimestamp") updatedTimestamp: Long? = null): List<InjuryResponse>
}

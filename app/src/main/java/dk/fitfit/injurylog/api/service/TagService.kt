package dk.fitfit.injurylog.api.service

import dk.fitfit.injurylog.dto.TagResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TagService {
    @GET("/tags/updates")
    suspend fun getUpdates(@Query("updatedTimestamp") updatedTimestamp: Long): List<TagResponse>
}

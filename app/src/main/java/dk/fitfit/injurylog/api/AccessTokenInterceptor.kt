package dk.fitfit.injurylog.api

import okhttp3.Interceptor
import okhttp3.Response
import java.net.SocketException

class AccessTokenInterceptor(private val accessTokenStorage: AccessTokenStorage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = accessTokenStorage.token()

        return if (token == null) {
            chain.proceed(chain.request())
        } else {
            // TODO: If token expired... Do something!
            // Try to refresh or get new auth token from Google and login again
            val authenticatedRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            try {
                chain.proceed(authenticatedRequest)
            } catch (e: SocketException) {
                Response.Builder().build()
            }
        }
    }
}

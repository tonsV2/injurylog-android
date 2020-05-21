package dk.fitfit.injurylog.api

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

// Inspiration: https://gist.github.com/naturalwarren/bc7f64f003a0e6034c6e74a2aa8917f6

/**
 * Authenticator that attempts to refresh the client's access token.
 * In the event that a refresh fails and a new token can't be issued an error
 * is delivered to the caller. This authenticator blocks all requests while a token
 * refresh is being performed. In-flight requests that fail with a 401 are
 * automatically retried.
 */
class AccessTokenAuthenticator(private val accessTokenStorage: AccessTokenStorage) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        // We need to have a token in order to refresh it.
        val token = accessTokenStorage.token() ?: return null

        synchronized(this) {
            val newToken = accessTokenStorage.token()

            // Check if the request made was previously made as an authenticated request.
            if (response.request().header("Authorization") != null) {

                // If the token has changed since the request was made, use the new token.
                if (newToken != token) {
                    return response.request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer $newToken")
                        .build()
                }

                val updatedToken = accessTokenStorage.refreshToken() ?: return null

                // Retry the request with the new token.
                return response.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer $updatedToken")
                    .build()
            }
        }
        return null
    }
}

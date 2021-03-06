package dk.fitfit.injurylog.api

import android.content.Context

const val TOKEN_STORE = "token-store"
const val ACCESS_TOKEN = "accessToken"
const val REFRESH_TOKEN = "refreshToken"
const val EXPIRES_IN = "expiresIn"

class AccessTokenStorage(context: Context) {
    private val settings = context.getSharedPreferences(TOKEN_STORE, Context.MODE_PRIVATE)

    fun token(): String? = settings.getString(ACCESS_TOKEN, null)
    fun refreshToken(): String? = settings.getString(REFRESH_TOKEN, null)
    fun expiresIn(): Int = settings.getInt(EXPIRES_IN, -1)

    fun store(accessToken: String, refreshToken: String, expiresIn: Int) {
        settings.edit()
            .putString(ACCESS_TOKEN, accessToken)
            .putString(REFRESH_TOKEN, refreshToken)
            .putInt(EXPIRES_IN, expiresIn)
            .apply()
    }
}

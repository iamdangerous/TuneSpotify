package com.example.tunespotify.util

import android.content.Context
import androidx.annotation.StringDef
import com.example.tunespotify.TuneSpotifyApp
import com.example.tunespotify.util.TokenType.Companion.KEY_ACCESS_TOKEN
import com.example.tunespotify.util.TokenType.Companion.KEY_REFRESH_TOKEN

object PreferenceUtil {
    val SHARED_PREF_NAME = "TuneSpotifySP"
    val pref = TuneSpotifyApp.INSTANCE.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    fun getSpotifyToken(@TokenType tokenType: String): String {
        return pref.getString(tokenType, "")!!
    }

    fun setSpotifyToken(@TokenType tokenType: String, value: String) {
        return pref.edit().putString(tokenType, value).apply()
    }
}

@Retention(AnnotationRetention.SOURCE)
@StringDef(KEY_ACCESS_TOKEN, KEY_REFRESH_TOKEN)
annotation class TokenType {
    companion object {
        const val KEY_ACCESS_TOKEN = "accessToken"
        const val KEY_REFRESH_TOKEN = "refreshToken"
    }

}
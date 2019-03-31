package com.example.tunespotify.util

import com.example.tunespotify.TuneSpotifyApp

object Constants {
    const val AUTHORIZATION = "Authorization"
    const val GRANT_TYPE = "grant_type"
    const val REFRESH_TOKEN = "refresh_token"
    val CONTENT_TYPE = "Content-Type"
    val CONTENT_TYPE_FORM_URL_ENCODED = "application/x-www-form-urlencoded"

    fun getUserAgent(): String {
        return "android:" + TuneSpotifyApp.INSTANCE.packageName + "v1.0" + "by (/u/rahul_lohra)"
    }

}
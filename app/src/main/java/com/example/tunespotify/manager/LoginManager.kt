package com.example.tunespotify.manager

import android.app.Activity
import com.example.tunespotify.util.Creds
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse


class LoginManager {
    val REQUEST_CODE = Creds.SPOTIFY_ACTIVITY_REQUEST_CODE
    val REDIRECT_URI = Creds.SPOTIFY_REDIRECT_URI
    val CLIENT_ID = Creds.SPOTIFY_CLIENT_ID

    fun openLoginActivity(activity: Activity) {
        AuthenticationClient.openLoginActivity(activity, REQUEST_CODE, getAuthRequest())
    }

    fun openBrowser(activity: Activity) {
        AuthenticationClient.openLoginInBrowser(activity, getAuthRequest())
    }

    private fun getAuthRequest(): AuthenticationRequest {
        val builder = AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI)
        builder.setScopes(arrayOf("streaming"))
        return builder.build()
    }
}
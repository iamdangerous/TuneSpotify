package com.example.tunespotify.repository

import android.util.Base64
import com.example.tunespotify.TuneSpotifyApp
import com.example.tunespotify.util.Constants
import com.example.tunespotify.util.Creds
import com.example.tunespotify.util.PreferenceUtil
import com.example.tunespotify.util.TokenType
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class TokenAuthenticator : Authenticator {

    var count = 0

    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.code() == 401) {
            ++count
            if (count == 2) {
                count = 0
                return null
            }

            val accessToken = PreferenceUtil.getSpotifyToken(TokenType.KEY_ACCESS_TOKEN)
            val refreshToken = PreferenceUtil.getSpotifyToken(TokenType.KEY_REFRESH_TOKEN)
            val authString = Creds.SPOTIFY_CLIENT_ID + ":"
            val encodedAuthString = Base64.encodeToString(authString.toByteArray(), Base64.NO_WRAP)

//            val apiInterface = provideRetrofitForToken().create(ApiInterface::class.java)
            val apiInterface = TuneSpotifyApp.apiInterface
            val header = "Basic $encodedAuthString"
            val res = apiInterface.refreshToken(
                header,
                refreshToken
            ).execute()
            if (res.code() == 200) {

                var newValidToken = "bearer "
                val newToken = res.body()!!.accessToken
                newValidToken += newToken
                //update in db
                PreferenceUtil.setSpotifyToken(TokenType.KEY_REFRESH_TOKEN, refreshToken)
                PreferenceUtil.setSpotifyToken(TokenType.KEY_ACCESS_TOKEN, newToken)

                return response.request().newBuilder()
                    .header(Constants.AUTHORIZATION, newValidToken)
                    .build()
            }
        }
        return null
    }

}
package com.example.tunespotify.util

import com.spotify.android.appremote.api.SpotifyAppRemote

object Creds {
    val SPOTIFY_CLIENT_ID = "78ced34f4eb742b4a9e007e6b6938eee"
    val SPOTIFY_REDIRECT_URI = "https://www.reddit.com"
    val SPOTIFY_ACTIVITY_REQUEST_CODE = 1337

    var SPOTIFY_REMOTE: SpotifyAppRemote? = null

}
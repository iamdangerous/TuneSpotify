package com.example.tunespotify.util

import com.spotify.android.appremote.api.SpotifyAppRemote

object Creds {
    val SPOTIFY_CLIENT_ID = "78ced34f4eb742b4a9e007e6b6938eee"
    val SPOTIFY_REDIRECT_URI = "https://www.reddit.com"
    val SPOTIFY_ACTIVITY_REQUEST_CODE = 1337

    var SPOTIFY_REMOTE: SpotifyAppRemote? = null

    private val listeningHistoryScope = arrayListOf<String>("user-read-recently-played", "user-top-read")
    private val libraryScope = arrayListOf<String>("user-library-modify", "user-library-read")
    private val playlistScope = arrayListOf<String>(
        "playlist-read-private",
        "playlist-modify-public",
        "playlist-modify-private",
        "playlist-read-collaborative"
    )
    private val usersScope = arrayListOf<String>("user-read-email", "user-read-birthdate", "user-read-private")
    private val spotifyConnectScope =
        arrayListOf<String>("user-read-playback-state", "user-modify-playback-state", "user-read-currently-playing")
    private val playbackScope = arrayListOf<String>("app-remote-control", "streaming")
    private val followScope = arrayListOf<String>("user-follow-read", "user-follow-modify")

    val scopesList = ArrayList<String>()

    init {
        scopesList.addAll(listeningHistoryScope)
        scopesList.addAll(libraryScope)
        scopesList.addAll(playlistScope)
        scopesList.addAll(usersScope)
        scopesList.addAll(spotifyConnectScope)
        scopesList.addAll(playbackScope)
        scopesList.addAll(followScope)
    }

}
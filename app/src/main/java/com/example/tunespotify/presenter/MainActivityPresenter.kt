package com.example.tunespotify.presenter

import android.content.Context
import android.util.Log
import com.example.tunespotify.util.Creds
import com.example.tunespotify.util.Creds.SPOTIFY_REMOTE
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector.ConnectionListener
import com.spotify.android.appremote.api.SpotifyAppRemote


class MainActivityPresenter {

    val TAG = "MainActPresenter"
    fun prepareConnection(): ConnectionParams {
        val clientId = Creds.SPOTIFY_CLIENT_ID
        val redirectUri = Creds.SPOTIFY_REDIRECT_URI
        return ConnectionParams.Builder(clientId)
            .setRedirectUri(redirectUri)
            .showAuthView(true)
            .build()
    }

    fun connectSpotify(context: Context, connectionParams: ConnectionParams) {
        SpotifyAppRemote.connect(context, connectionParams, object : ConnectionListener {
            override fun onFailure(p0: Throwable?) {
                Log.d(TAG, "fail: ${p0?.message}")
            }

            override fun onConnected(p0: SpotifyAppRemote?) {
                SPOTIFY_REMOTE = p0
                Log.d(TAG, "onConnected")
            }

        })
    }

    fun logoutSpotify(appRemote: SpotifyAppRemote) {
        SpotifyAppRemote.disconnect(appRemote);
    }

    fun playDemoPlayList(appRemote: SpotifyAppRemote) {
        val testPlaylist = "spotify:playlist:37i9dQZF1DX2sUQwD7tbmL"
        appRemote.playerApi.play(testPlaylist)

        appRemote.playerApi.subscribeToPlayerState().setEventCallback {
            val track = it.track;
            if (track != null) {
                Log.d(TAG, track.name + " by " + track.artist.name);
            }
        }
    }
}
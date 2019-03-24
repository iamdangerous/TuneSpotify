package com.example.tunespotify

import android.app.Application

class TuneSpotifyApp:Application(){

    companion object {
        lateinit var INSTANCE:Application
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}
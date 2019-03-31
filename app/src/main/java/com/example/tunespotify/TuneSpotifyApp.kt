package com.example.tunespotify

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.tunespotify.presenter.ApplicationPresenter
import com.example.tunespotify.repository.ApiInterface
import com.example.tunespotify.util.ApiEndpoints
import okhttp3.OkHttpClient

class TuneSpotifyApp : Application() {

    companion object {
        lateinit var INSTANCE: Application
        var BEARER_TOKEN = ""
        lateinit var apiInterface: ApiInterface
    }

    lateinit var okHttpClient: OkHttpClient

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        val presenter = ApplicationPresenter()
        okHttpClient = presenter.createOkHttpClient()
        apiInterface = presenter.createWebService<ApiInterface>(okHttpClient, ApiEndpoints.BASE_URL)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
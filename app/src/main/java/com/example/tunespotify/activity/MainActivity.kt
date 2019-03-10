package com.example.tunespotify.activity

import android.os.Bundle
import android.view.View
import com.example.tunespotify.R
import com.example.tunespotify.presenter.MainActivityPresenter
import com.example.tunespotify.util.Creds
import com.spotify.android.appremote.api.ConnectionParams

class MainActivity : BaseActivity() {

    lateinit var presenter: MainActivityPresenter
    var connectParams: ConnectionParams? = null

    lateinit var btnLogin: View
    lateinit var btnPlay: View
    lateinit var btnLogout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVars()
        setClicks()
    }

    fun initVars() {
        presenter = MainActivityPresenter()

        btnLogin = findViewById(R.id.btnLogin)
        btnPlay = findViewById(R.id.btnPlay)
        btnLogout = findViewById(R.id.btnLogout)
    }

    fun setClicks() {
        btnLogin.setOnClickListener {
            prepareConnectionAndConnect()
        }

        btnPlay.setOnClickListener {
            Creds.SPOTIFY_REMOTE?.let {
                presenter.playDemoPlayList(it)
            }

        }

        btnLogout.setOnClickListener {
            Creds.SPOTIFY_REMOTE?.let {
                presenter.logoutSpotify(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        prepareConnectionAndConnect()
    }

    fun prepareConnectionAndConnect() {
        if (Creds.SPOTIFY_REMOTE == null) {
            if (connectParams == null)
                connectParams = presenter.prepareConnection()
            connectParams?.let {
                presenter.connectSpotify(this, it)
            }
        }
    }
}

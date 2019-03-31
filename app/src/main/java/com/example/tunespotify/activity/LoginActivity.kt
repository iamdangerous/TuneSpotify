package com.example.tunespotify.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.tunespotify.R
import com.example.tunespotify.manager.LoginActivityResult
import com.example.tunespotify.manager.LoginManager
import com.example.tunespotify.presenter.MainActivityPresenter
import com.example.tunespotify.util.Creds
import com.example.tunespotify.util.ToastUtil
import com.spotify.android.appremote.api.ConnectionParams


class LoginActivity : BaseActivity() {

    lateinit var presenter: MainActivityPresenter
    var connectParams: ConnectionParams? = null

    lateinit var btnLogin: View
    lateinit var btnPlay: View
    lateinit var btnLogout: View

    private fun getLayout() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        initVars()
        setClicks()
    }

    fun initVars() {
        presenter = MainActivityPresenter(object : MainActivityPresenter.MainActivityPresenterCallback {
            override fun onUserNotLoggedIn() {
                openLoginUI()
            }

            override fun onUserConnected() {
            }

        })

        btnLogin = findViewById(R.id.btnLogin)
        btnPlay = findViewById(R.id.btnPlay)
        btnLogout = findViewById(R.id.btnLogout)
    }

    fun setClicks() {
        btnLogin.setOnClickListener {
            prepareConnectionAndConnect()
        }

        btnPlay.setOnClickListener {
            if (Creds.isSpotifyConnected) {
                presenter.playDemoPlayList(Creds.SPOTIFY_REMOTE!!)
            }

        }

        btnLogout.setOnClickListener {
            if (Creds.isSpotifyConnected) {
                presenter.logoutSpotify(Creds.SPOTIFY_REMOTE!!)
            }
        }
    }

    fun prepareConnectionAndConnect() {
        if (!Creds.isSpotifyConnected) {
            if (connectParams == null)
                connectParams = presenter.prepareConnection()
            connectParams?.let {
                presenter.connectSpotify(this, it)
            }
        } else {
            ToastUtil.show("User already connected")
        }
    }

    fun openLoginUI() {
        val loginManager = LoginManager()
        loginManager.openLoginActivity(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val loginActivityResult = LoginActivityResult()
        loginActivityResult.handleResult(requestCode, resultCode, data)
    }
}

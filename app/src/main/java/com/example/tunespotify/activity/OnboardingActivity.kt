package com.example.tunespotify.activity

import android.content.Intent
import android.os.Bundle

class OnboardingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handleLoggedInState()
    }

    fun handleLoggedInState() {
        val isLoggedIn = false

        var dest: Class<*> = TimelineActivity::class.java
        if (isLoggedIn) {
            //Do nothing
        } else {

            dest = LoginActivity::class.java
        }
        startActivity(Intent(this, dest))
    }
}
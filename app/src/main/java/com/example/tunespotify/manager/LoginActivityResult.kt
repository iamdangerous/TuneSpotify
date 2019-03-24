package com.example.tunespotify.manager

import android.content.Intent
import com.example.tunespotify.util.Creds
import com.example.tunespotify.util.ToastUtil
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse

class LoginActivityResult{
    fun handleResult(requestCode: Int, resultCode: Int, data: Intent?){
        if (requestCode == Creds.SPOTIFY_ACTIVITY_REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, data)

            when (response.type) {
                // Response was successful and contains auth token
                AuthenticationResponse.Type.TOKEN -> {
                    ToastUtil.show("Success")
//                    prepareConnectionAndConnect()
                }

                // Auth flow returned an error
                AuthenticationResponse.Type.ERROR -> {
                    ToastUtil.show("Error")
                }

                AuthenticationResponse.Type.EMPTY -> {
                    ToastUtil.show("Empty")
                }
            }// Handle successful response
            // Handle error response
            // Most likely auth flow was cancelled
            // Handle other cases
        }
    }
}
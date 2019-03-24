package com.example.tunespotify.util

import android.widget.Toast
import com.example.tunespotify.TuneSpotifyApp

object ToastUtil{
    fun show(msg:String){
        Toast.makeText(TuneSpotifyApp.INSTANCE.applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}
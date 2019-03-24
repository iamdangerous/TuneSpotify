package com.example.tunespotify.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class BaseButton : AppCompatButton {

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int):super(context, attrs, defStyleAttr){
    }

    constructor(context: Context?, attrs: AttributeSet?):super(context, attrs){
    }
    constructor(context: Context?):super(context){
    }

}
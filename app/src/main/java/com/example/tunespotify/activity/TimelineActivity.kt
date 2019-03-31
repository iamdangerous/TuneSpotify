package com.example.tunespotify.activity

import android.os.Bundle
import com.example.tunespotify.R
import com.example.tunespotify.adapter.fragmentAdapter.TimelineFragmentAdapter
import com.example.tunespotify.presenter.TimelinePresenter
import kotlinx.android.synthetic.main.activity_timeline.*

class TimelineActivity : BaseActivity() {

    private val presenter = TimelinePresenter()
    private fun getLayout() = R.layout.activity_timeline

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initVars()
    }

    private fun initVars() {
        val adapter = TimelineFragmentAdapter(supportFragmentManager, presenter.getFragments())
        view_pager.adapter = adapter
    }

}
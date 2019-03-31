package com.example.tunespotify.fragment.timelineFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tunespotify.R
import com.example.tunespotify.adapter.rvAdapter.FeedAdapter
import com.example.tunespotify.presenter.fragment.FeedPresenter
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : BaseFragment() {

    val feedPresenter = FeedPresenter()
    val dataList = ArrayList<String>()
    fun getLayout() = R.layout.fragment_feed

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = LayoutInflater.from(context).inflate(getLayout(), container, false)
        initVars()
        return layout
    }

    fun initVars() {
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = FeedAdapter(dataList)
    }

}
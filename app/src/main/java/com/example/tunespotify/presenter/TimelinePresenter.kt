package com.example.tunespotify.presenter

import androidx.fragment.app.Fragment
import com.example.tunespotify.fragment.timelineFragments.FeedFragment
import com.example.tunespotify.fragment.timelineFragments.LibraryFragment
import com.example.tunespotify.fragment.timelineFragments.SearchFrament

class TimelinePresenter {
    fun getFragments(): ArrayList<Fragment> {
        val listOfFragments = ArrayList<Fragment>()
        listOfFragments.add(FeedFragment())
        listOfFragments.add(LibraryFragment())
        listOfFragments.add(SearchFrament())
        return listOfFragments
    }
}
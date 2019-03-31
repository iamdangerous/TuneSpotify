package com.example.tunespotify.adapter.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tunespotify.R

class FeedAdapter(val dataList: ArrayList<*>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val li = LayoutInflater.from(parent.context).inflate(R.layout.li_feed_temp, parent, false)
        val vh = TempVH(li)
        return vh
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    class TempVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

        }
    }

}
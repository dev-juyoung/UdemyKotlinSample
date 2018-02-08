package com.dev_juyoung.udemykotlinsample.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev_juyoung.udemykotlinsample.R
import com.dev_juyoung.udemykotlinsample.data.schme.ImageData

/**
 * Created by juyounglee on 2018. 2. 8..
 */
class HomeRecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
        HomeAdapterContract.View,
        HomeAdapterContract.Model {

    private var data = mutableListOf<ImageData>()

    override fun updateView() {
        notifyDataSetChanged()
    }

    override fun addItems(images: List<ImageData>) {
        data.addAll(images)
    }

    override fun updateItems(images: List<ImageData>) {
        data = images as MutableList<ImageData>
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val viewHolder = holder as? ImageViewHolder
        viewHolder?.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size
}
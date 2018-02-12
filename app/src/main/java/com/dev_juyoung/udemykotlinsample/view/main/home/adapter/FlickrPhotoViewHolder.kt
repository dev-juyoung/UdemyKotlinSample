package com.dev_juyoung.udemykotlinsample.view.main.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.dev_juyoung.udemykotlinsample.data.schme.Photo
import kotlinx.android.synthetic.main.item_image.view.*

/**
 * Created by juyounglee on 2018. 2. 8..
 */
class FlickrPhotoViewHolder(itemView: View?, onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView?.setOnClickListener { onItemClicked(adapterPosition) }
    }

    fun onBind(item: Photo) {
        itemView.run {
            imageView.load(item.getPhotoURI())
            textView.text = item.getTitleInfo()
        }
    }
}
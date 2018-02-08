package com.dev_juyoung.udemykotlinsample.view.main.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.dev_juyoung.udemykotlinsample.data.schme.ImageData
import kotlinx.android.synthetic.main.item_image.view.*

/**
 * Created by juyounglee on 2018. 2. 8..
 */
class ImageViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun onBind(item: ImageData) {
        itemView.run {
            imageView.setImageResource(resources.getIdentifier(item.url, "drawable", context.packageName))
            textView.text = item.name
        }
    }
}
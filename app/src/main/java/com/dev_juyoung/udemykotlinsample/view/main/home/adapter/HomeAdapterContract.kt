package com.dev_juyoung.udemykotlinsample.view.main.home.adapter

import com.dev_juyoung.udemykotlinsample.data.schme.Photo

/**
 * Created by juyounglee on 2018. 2. 8..
 */
interface HomeAdapterContract {
    interface View {
        fun updateView()
        var onItemClicked: (Int) -> Unit
    }

    interface Model {
        fun addItems(photos: List<Photo>)
        fun updateItems(photos: List<Photo>)
        fun getItem(position: Int): Photo
    }
}
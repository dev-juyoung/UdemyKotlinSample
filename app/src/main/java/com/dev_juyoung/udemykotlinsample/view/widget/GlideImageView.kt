package com.dev_juyoung.udemykotlinsample.view.widget

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import com.dev_juyoung.udemykotlinsample.R
import com.dev_juyoung.udemykotlinsample.util.GlideApp

/**
 * Created by juyounglee on 2018. 2. 8..
 */
open class GlideImageView @JvmOverloads constructor(
        context: Context,
        attr: AttributeSet? = null,
        defStyleAttr: Int = 0
) : AppCompatImageView(context, attr, defStyleAttr) {

    fun load(url: String?, @DrawableRes placeholderResId: Int = R.drawable.sample_01) {
        GlideApp.with(this)
                .load(url)
                .placeholder(placeholderResId)
                .centerCrop()
                .into(this)
    }
}
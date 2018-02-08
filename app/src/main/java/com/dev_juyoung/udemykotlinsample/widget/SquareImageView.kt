package com.dev_juyoung.udemykotlinsample.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by juyounglee on 2018. 2. 8..
 */
class SquareImageView @JvmOverloads constructor(
        context: Context,
        attr: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ImageView(
        context,
        attr,
        defStyleAttr
) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

}
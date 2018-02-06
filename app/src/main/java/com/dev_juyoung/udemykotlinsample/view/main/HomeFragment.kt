package com.dev_juyoung.udemykotlinsample.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev_juyoung.udemykotlinsample.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by juyounglee on 2018. 2. 6..
 */

class HomeFragment : Fragment() {
    companion object {
        val KEY_TITLE = "key-title"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = arguments.getInt(KEY_TITLE).toString()
    }
}
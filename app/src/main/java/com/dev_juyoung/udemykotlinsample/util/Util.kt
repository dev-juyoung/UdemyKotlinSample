package com.dev_juyoung.udemykotlinsample.util

import android.content.Context
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import java.util.*

/**
 * Created by juyounglee on 2018. 2. 6..
 */

fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: Fragment, tag: String? = null) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start)
package com.starwars.ui.extensions

import android.content.Context
import android.view.Gravity
import android.widget.Toast

fun Context.toast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(this, message, duration).apply {

    }.show()
}
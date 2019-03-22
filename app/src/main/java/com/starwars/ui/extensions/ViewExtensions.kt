package com.starwars.ui.extensions

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.squareup.picasso.Picasso
import com.starwars.data.remote.service.BASE_URL_IMAGE

fun Context.toast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(this, message, duration).show()
}

fun RecyclerView.createScrollListener(
    conditionFunction: (Int) -> Boolean,
    function: () -> Unit
) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val lastVisibleItem = layoutManager.findLastVisibleItemPosition() + 1
            if (conditionFunction(lastVisibleItem)) {
                function()
            }
        }
    })
}

fun SwipeRefreshLayout.loading() {
    isRefreshing = true
}

fun SwipeRefreshLayout.stopLoading() {
    isRefreshing = false
}

fun ImageView.loadUrl(url: String, @IdRes placeholder: Int? = null) {
    Picasso.get()
        .load(BASE_URL_IMAGE + url)
        .apply { placeholder?.let { placeholder(it) } }
        .into(this)
}

fun View.hide() { visibility = View.GONE }

fun View.show() { visibility = View.VISIBLE }
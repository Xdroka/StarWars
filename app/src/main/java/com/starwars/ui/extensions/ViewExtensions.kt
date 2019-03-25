package com.starwars.ui.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import com.starwars.data.remote.service.BASE_URL_IMAGE
import java.lang.Exception

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

fun ImageView.loadUrl(url: String, @DrawableRes placeholder: Int? = android.R.drawable.gallery_thumb) {
    Picasso.get()
        .load(url)
        .apply { placeholder?.let { placeholder(it) } }
        .into(this)
}

fun RecyclerView.addDefaultDecorator(activity: Activity) {
    addItemDecoration(DividerItemDecoration(activity, activity.requestedOrientation))
}

fun View.hide() { visibility = View.GONE }

fun View.show() { visibility = View.VISIBLE }

fun View.loadUrlImages(url: String) {
    Picasso.get()
        .load(url)
        .into(object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}
            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}
            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                background = bitmap?.toDrawable(resources)
            }
        })
}
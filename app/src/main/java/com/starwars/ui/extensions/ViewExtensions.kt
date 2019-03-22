package com.starwars.ui.extensions

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun Context.toast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(this, message, duration).apply {

    }.show()
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

fun SwipeRefreshLayout.loading() { isRefreshing = true }

fun SwipeRefreshLayout.stopLoading() { isRefreshing = false }
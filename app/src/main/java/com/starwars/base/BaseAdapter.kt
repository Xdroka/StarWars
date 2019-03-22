package com.starwars.base

import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH: RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    private var lastLoadedPosition = -1

    protected fun setAppearingAnimation(position: Int, viewToAnimate: View) {
        if (position > lastLoadedPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastLoadedPosition = position
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        setAppearingAnimation(position, holder.itemView)
    }

}
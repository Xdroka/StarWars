package com.starwars.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.starwars.domain.model.Specie

class SpecieListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(item: Specie, onClickItem: ((Specie) -> Unit)?){
        itemView.apply {
            setOnClickListener { onClickItem?.invoke(item) }

        }
    }
}
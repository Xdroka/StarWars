package com.starwars.ui.adapters

import android.view.View
import com.starwars.domain.model.Character
import androidx.recyclerview.widget.RecyclerView

class CharacterListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Character, onClick: ((Character) -> Unit)? = null) {
        itemView.apply {
            setOnClickListener { onClick?.invoke(item) }
        }
    }
}
package com.starwars.ui.adapters

import android.view.View
import com.starwars.domain.model.Character
import androidx.recyclerview.widget.RecyclerView
import com.starwars.R
import com.starwars.data.remote.service.CHARACTERS_MEDIA_ENDPOINT
import com.starwars.ui.extensions.loadUrl
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Character, onClick: ((Character) -> Unit)? = null) {
        itemView.apply {
            setOnClickListener { onClick?.invoke(item) }
            itemCharacterImageView.loadUrl(CHARACTERS_MEDIA_ENDPOINT.format(item.id))
            itemNameCharacterTv.text = item.name
            itemWorldCharacterTv.text = context.getString(R.string.birth_year_format2).format(item.birthYear)
        }
    }
}
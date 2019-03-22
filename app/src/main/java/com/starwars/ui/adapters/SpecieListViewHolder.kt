package com.starwars.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.starwars.R
import com.starwars.data.remote.service.SPECIES_MEDIA_ENDPOINT
import com.starwars.domain.model.Specie
import com.starwars.ui.extensions.loadUrl
import kotlinx.android.synthetic.main.item_specie.view.*

class SpecieListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(item: Specie, onClickItem: ((Specie) -> Unit)?){
        itemView.apply {
            setOnClickListener { onClickItem?.invoke(item) }
            itemSpecieClassTv.text = context.getString(R.string.classification_format).format(item.classification)
            itemSpecieImageView.loadUrl(SPECIES_MEDIA_ENDPOINT.format(item.id))
            itemSpecieLanguageTv.text = context.getString(R.string.language_format).format(item.language)
            itemSpecieNameTv.text = item.name
        }
    }
}
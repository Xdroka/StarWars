package com.starwars.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.starwars.data.remote.service.FILMS_MEDIA_ENDPOINT
import com.starwars.domain.model.Film
import com.starwars.ui.extensions.loadUrl
import kotlinx.android.synthetic.main.item_film.view.*

class FilmListViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(item: Film, onClick: ((Film) -> Unit)? = null){
        itemView.apply {
            setOnClickListener { onClick?.invoke(item) }
            itemTitleFilmTv.text = item.title
            itemFilmImageView.loadUrl(FILMS_MEDIA_ENDPOINT.format(item.id))
        }
    }
}
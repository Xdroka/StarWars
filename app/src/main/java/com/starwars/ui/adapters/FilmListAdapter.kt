package com.starwars.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.starwars.R
import com.starwars.base.BaseAdapter
import com.starwars.domain.model.Film

class FilmListAdapter(
    val filmList: MutableList<Film> = mutableListOf(),
    private val onClick: ((Film) -> Unit) ? = null
): BaseAdapter<FilmListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder =
        FilmListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        )

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(filmList[position], onClick)
    }

    override fun getItemCount(): Int = filmList.size
}
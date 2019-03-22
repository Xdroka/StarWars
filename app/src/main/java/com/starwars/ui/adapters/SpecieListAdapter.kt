package com.starwars.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.starwars.R
import com.starwars.base.BaseAdapter
import com.starwars.domain.model.Specie

class SpecieListAdapter(
    val specieList: MutableList<Specie> = mutableListOf(),
    private val onClickItem: ((Specie) -> Unit)? = null
) : BaseAdapter<SpecieListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieListViewHolder =
        SpecieListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_specie, parent, false)
        )

    override fun getItemCount(): Int = specieList.size

    override fun onBindViewHolder(holder: SpecieListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(specieList[position], onClickItem)
    }
}
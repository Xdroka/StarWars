package com.starwars.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.starwars.R
import com.starwars.base.BaseAdapter
import com.starwars.domain.model.Character

class CharacterListAdapter(
    val charactersList: MutableList<Character> = mutableListOf(),
    private val onClick: ((Character) -> Unit)? = null
    ): BaseAdapter<CharacterListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder =
        CharacterListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )

    override fun getItemCount(): Int = charactersList.size

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(charactersList[position], onClick)
    }
}
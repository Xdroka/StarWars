package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.gson.JsonSyntaxException
import com.starwars.R
import com.starwars.base.BaseFragment
import com.starwars.data.remote.service.CHARACTERS_MEDIA_ENDPOINT
import com.starwars.domain.model.Character
import com.starwars.ui.extensions.fromGson
import com.starwars.ui.extensions.loadUrl
import kotlinx.android.synthetic.main.fragment_character_details.*

class CharacterDetailsFragment : BaseFragment() {
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_character_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillCharactersData()
    }

    private fun fillCharactersData(){
        val character: Character
        try{
            character = args.character.fromGson<Character>()?: return
        }catch (e: JsonSyntaxException){ return }
        character.apply {
            characterDetailsImageView.loadUrl(CHARACTERS_MEDIA_ENDPOINT.format(id))
            nameCharDetailsTv.text = name
            genderCharDetailsTv.text = getString(R.string.gender_format).format(gender)
            heightCharDetailsTv.text = getString(R.string.height_format).format(height)
            massCharDetailsTv.text = getString(R.string.mass_format).format(mass)
            homeWorldCharDetailsTv.text = getString(R.string.home_world_format).format(homeWorld)
        }
    }

}

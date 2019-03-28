package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.starwars.R
import com.starwars.base.BaseFragment
import com.starwars.data.remote.service.SPECIES_MEDIA_ENDPOINT
import com.starwars.domain.model.Specie
import com.starwars.ui.extensions.fromGson
import com.starwars.ui.extensions.loadUrl
import kotlinx.android.synthetic.main.fragment_specie_details.*

class SpecieDetailsFragment : BaseFragment() {
    private val args: SpecieDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_specie_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillSpecieData()
    }

    private fun fillSpecieData() {
        val specie = args.specie.fromGson<Specie>() ?: return
        specieDetailsImageView.loadUrl(SPECIES_MEDIA_ENDPOINT.format(specie.id))
        nameSpecieDetailsTv.text = specie.name
        averageLifeSpecieDetailsTv.text = getString(R.string.average_life_format).format(specie.averageLifespan)
        skinColorSpecieDetailsTv.text = getString(R.string.skin_color_format).format(specie.skinColors)
        classSpecieDetailsTv.text = getString(R.string.classification_format).format(specie.classification)
        languageSpecieDetailsTv.text = getString(R.string.language_format).format(specie.language)
        skinHairSpecieDetailsTv.text = getString(R.string.skin_hair_format).format(specie.hairColors)
    }

}

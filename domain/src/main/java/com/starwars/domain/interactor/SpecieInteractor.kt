package com.starwars.domain.interactor

import com.starwars.data.remote.Response
import com.starwars.domain.model.Specie

interface SpecieInteractor{
    suspend fun getSpecies(page: Int): Response<MutableList<Specie>>
}
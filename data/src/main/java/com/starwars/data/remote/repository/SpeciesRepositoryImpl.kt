package com.starwars.data.remote.repository

import com.starwars.data.remote.service.SpeciesWebService
import com.starwars.data.remote.service.apiCall

class SpeciesRepositoryImpl(
    private val service: SpeciesWebService
) : SpeciesRepository {

    override suspend fun getSpecie(page: Int) = apiCall{ service.getAllSpecies(page) }

}
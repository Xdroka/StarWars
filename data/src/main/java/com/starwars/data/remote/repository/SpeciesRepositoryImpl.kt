package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.SpecieListResponse
import com.starwars.data.remote.service.SpeciesWebService

class SpeciesRepositoryImpl(
    private val service: SpeciesWebService
) : SpeciesRepository {

    override suspend fun getSpecie(page: Int): Response<SpecieListResponse> = service.getAllSpecies(page)

}
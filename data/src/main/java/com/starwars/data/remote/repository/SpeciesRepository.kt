package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.SpecieListResponse
import com.starwars.data.remote.model.SpecieResponse

interface SpeciesRepository {
    suspend fun getSpecies(page: Int): Response<SpecieListResponse>
    suspend fun getSpecie(specieId: Int): Response<SpecieResponse>
}
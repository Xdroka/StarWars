package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.SpecieListResponse

interface SpeciesRepository {
    suspend fun getSpecie(page: Int): Response<SpecieListResponse>
}
package com.starwars.data.remote.service

import com.starwars.data.remote.model.SpecieListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface SpeciesWebService {
    @GET(SPECIES_ENDPOINT)
    fun getAllSpecies(@Query("page") page: Int): Deferred<SpecieListResponse>
}
package com.starwars.data.remote.service

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.SpeciesResponse
import retrofit2.http.GET

interface SpeciesWebService {
    @GET(SPECIES_ENDPOINT)
    fun getAllSpecies(): Response<SpeciesResponse>
}
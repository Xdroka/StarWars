package com.starwars.data.remote.service

import com.starwars.data.remote.model.SpecieListResponse
import com.starwars.data.remote.model.SpecieResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpeciesWebService {
    @GET(SPECIES_ENDPOINT)
    fun getAllSpecies(@Query(PAGE_QUERY) page: Int): Deferred<SpecieListResponse>

    @GET("$SPECIES_ENDPOINT{$ID_PATH}")
    fun getSpecie(@Path(ID_PATH) specieId: Int): Deferred<SpecieResponse>
}
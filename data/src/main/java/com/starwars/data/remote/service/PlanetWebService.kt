package com.starwars.data.remote.service

import com.starwars.data.remote.model.PlanetResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetWebService {
    @GET("$PLANETS_ENDPOINT{$ID_PATH}")
    fun getPlanet(@Path(ID_PATH) planetId: Int): Deferred<PlanetResponse>
}
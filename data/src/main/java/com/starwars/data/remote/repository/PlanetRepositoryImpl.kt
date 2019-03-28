package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.PlanetResponse
import com.starwars.data.remote.service.PlanetWebService
import com.starwars.data.remote.service.apiCall

class PlanetRepositoryImpl(
    private val planetService: PlanetWebService
) : PlanetRepository {
    override suspend fun getPlanet(planetId: Int): Response<PlanetResponse> =
        apiCall { planetService.getPlanet(planetId) }
}
package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.PlanetResponse

interface PlanetRepository {
    suspend fun getPlanet(planetId: Int): Response<PlanetResponse>
}
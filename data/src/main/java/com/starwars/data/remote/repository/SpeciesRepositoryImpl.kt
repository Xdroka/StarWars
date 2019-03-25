package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.SpecieListResponse
import com.starwars.data.remote.model.SpecieResponse
import com.starwars.data.remote.service.SpeciesWebService
import com.starwars.data.remote.service.apiCall

class SpeciesRepositoryImpl(
    private val service: SpeciesWebService
) : SpeciesRepository {
    private var lastPage: Int? = null

    override suspend fun getSpecies(page: Int): Response<SpecieListResponse> {
        if(lastPage != null){
            lastPage = null
            return Response.Success(SpecieListResponse(results = listOf()))
        }
        val response = apiCall { service.getAllSpecies(page) }
        return when(response){
            is Response.Failure -> response
            is Response.Success -> {
                if(response.data.next == null) lastPage = page + 1
                response
            }
        }
    }

    override suspend fun getSpecie(specieId: Int): Response<SpecieResponse> =
            apiCall{ service.getSpecie(specieId) }
}
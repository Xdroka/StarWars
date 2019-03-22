package com.starwars.domain.interactor

import com.starwars.data.remote.Response
import com.starwars.data.remote.repository.SpeciesRepository
import com.starwars.domain.mapper.toMutableList
import com.starwars.domain.model.Specie

class SpecieInteractorImpl(
    private val repository: SpeciesRepository
): SpecieInteractor{
    override suspend fun getSpecies(page: Int): Response<MutableList<Specie>> {
        val response = repository.getSpecie(page)
        return when(response){
            is Response.Failure -> response
            is Response.Success -> Response.Success(response.data.toMutableList())
        }
    }
}
package com.starwars.domain.interactor

import com.starwars.data.remote.Response
import com.starwars.data.remote.repository.FilmsRepository
import com.starwars.domain.mapper.toMutableList
import com.starwars.domain.model.Film

class FilmsInteractorImpl(
    private val filmRepository: FilmsRepository
) : FilmsInteractor {
    override suspend fun getFilms(page: Int): Response<MutableList<Film>> {
        val response = filmRepository.getFilms(page)
        return when (response) {
            is Response.Failure -> response
            is Response.Success -> Response.Success(response.data.toMutableList())
        }
    }
}
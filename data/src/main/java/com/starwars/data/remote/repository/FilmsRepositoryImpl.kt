package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.FilmListResponse
import com.starwars.data.remote.service.FilmWebService
import com.starwars.data.remote.service.apiCall

class FilmsRepositoryImpl(
    private val service: FilmWebService
) : FilmsRepository {
    private var lastPage: Int? = null

    override suspend fun getFilms(page: Int): Response<FilmListResponse> {
        if (lastPage != null) {
            lastPage = null
            return Response.Success(FilmListResponse())
        }
        val response = apiCall { service.getFilms(page) }
        return when (response) {
            is Response.Failure -> response
            is Response.Success -> {
                if (response.data.next == null) lastPage = page + 1
                response
            }
        }
    }
}
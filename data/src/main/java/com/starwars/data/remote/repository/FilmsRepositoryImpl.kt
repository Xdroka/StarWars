package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.FilmListResponse
import com.starwars.data.remote.service.FilmWebService
import com.starwars.data.remote.service.apiCall

class FilmsRepositoryImpl(
    private val service: FilmWebService
) : FilmsRepository {
    override suspend fun getFilms(page: Int): Response<FilmListResponse> =
        apiCall { service.getFilms(page) }
}
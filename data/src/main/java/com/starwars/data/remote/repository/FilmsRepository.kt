package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.FilmListResponse

interface FilmsRepository {
    suspend fun getFilms(page: Int): Response<FilmListResponse>
}
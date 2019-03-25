package com.starwars.data.remote.service

import com.starwars.data.remote.model.FilmListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmWebService {
    @GET(FILMS_ENDPOINT)
    fun getFilms(@Query(PAGE_QUERY) page: Int): Deferred<FilmListResponse>
}
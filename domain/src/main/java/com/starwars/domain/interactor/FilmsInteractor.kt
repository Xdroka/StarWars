package com.starwars.domain.interactor

import com.starwars.data.remote.Response
import com.starwars.domain.model.Film

interface FilmsInteractor{
    suspend fun getFilms(page: Int): Response<MutableList<Film>>
}
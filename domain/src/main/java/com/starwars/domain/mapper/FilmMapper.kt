package com.starwars.domain.mapper

import com.starwars.data.remote.model.FilmListResponse
import com.starwars.domain.model.Film

fun FilmListResponse.toMutableList() =
    this.results.map {
        Film(
            id = getId(it.url),
            title = it.title,
            director = it.director,
            producer = it.producer,
            releaseDate = it.releaseDate.toDate("yyyy-mm-dd")
        )
    }.toMutableList()
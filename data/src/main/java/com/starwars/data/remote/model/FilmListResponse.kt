package com.starwars.data.remote.model

data class FilmListResponse(
    val count: Int = 0,
    val next: String? = null,
    val previous: String? = null,
    val results: List<FilmResponse> = listOf()
)

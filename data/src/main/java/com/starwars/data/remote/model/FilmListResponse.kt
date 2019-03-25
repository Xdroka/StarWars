package com.starwars.data.remote.model

import com.google.gson.annotations.SerializedName

data class FilmListResponse(
    val count: Int = 0,
    val next: Any? = Any(),
    val previous: Any? = Any(),
    @SerializedName("results") val films: List<FilmResponse> = listOf()
)

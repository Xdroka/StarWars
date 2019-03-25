package com.starwars.domain.model

import java.util.*

data class Film(
    val id: Int,
    val title: String,
    val director: String,
    val producer: String,
    val releaseDate: Date
)
package com.starwars.data.remote.model

data class FilmResponse(
    val created: String = "",
    val director: String = "",
    val edited: String = "",
    val episode_id: Int = 0,
    val opening_crawl: String = "",
    val planets: List<String> = listOf(),
    val producer: String = "",
    val release_date: String = "",
    val species: List<String> = listOf(),
    val starships: List<String> = listOf(),
    val title: String = "",
    val url: String = "",
    val vehicles: List<Any> = listOf()
)
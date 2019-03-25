package com.starwars.data.remote.model

import com.google.gson.annotations.SerializedName
import com.starwars.data.remote.service.episodeIdField
import com.starwars.data.remote.service.openingCrawlField
import com.starwars.data.remote.service.releaseDateField
import com.starwars.data.remote.service.starShipField

data class FilmResponse(
    val created: String = "",
    val director: String = "",
    val edited: String = "",
    val planets: List<String> = listOf(),
    val producer: String = "",
    val species: List<String> = listOf(),
    val title: String = "",
    val url: String = "",
    val vehicles: List<Any> = listOf(),
    @SerializedName(episodeIdField) val episodeId: Int = 0,
    @SerializedName(openingCrawlField) val openingCrawl: String = "",
    @SerializedName(releaseDateField) val releaseDate: String = "",
    @SerializedName(starShipField) val starShips: List<String> = listOf()
)
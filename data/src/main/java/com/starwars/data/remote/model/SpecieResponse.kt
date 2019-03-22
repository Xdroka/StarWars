package com.starwars.data.remote.model

import com.google.gson.annotations.SerializedName

data class SpecieResponse(
    @SerializedName("average_height") val averageHeight: String? = null,
    @SerializedName("average_lifespan") val averageLifespan: String? = null,
    val classification: String? = null,
    val created: String? = null,
    val designation: String? = null,
    val edited: String? = null,
    @SerializedName("eye_colors") val eyeColors: String? = null,
    val films: List<String>? = null,
    @SerializedName("hair_colors") val hairColors: String? = null,
    val homeworld: String? = null,
    val language: String? = null,
    val name: String? = null,
    val people: List<String>? = null,
    @SerializedName("skin_colors") val skinColors: String? = null,
    val url: String? = null
)
package com.starwars.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val created: String? = null,
    val edited: String? = null,
    val gender: String? = null,
    val height: String? = null,
    val mass: String? = null,
    val name: String? = null,
    val url: String? = null,
    val species: List<String> = listOf("n/a"),
    @SerializedName("homeworld") val homeWorld: String? = null,
    @SerializedName("eye_color") val eyeColor: String? = null,
    @SerializedName("birth_year") val birthYear: String? = null,
    @SerializedName("hair_color") val hairColor: String? = null,
    @SerializedName("skin_color") val skinColor: String? = null
)
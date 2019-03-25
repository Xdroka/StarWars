package com.starwars.data.remote.model

import com.google.gson.annotations.SerializedName
import com.starwars.data.remote.service.*

data class CharacterResponse(
    val created: String? = null,
    val edited: String? = null,
    val gender: String? = null,
    val height: String? = null,
    val mass: String? = null,
    val name: String? = null,
    val url: String? = null,
    val species: List<String> = listOf(noneField),
    @SerializedName(homeWorldField) val homeWorld: String? = null,
    @SerializedName(eyeColorField) val eyeColor: String? = null,
    @SerializedName(birthDayField) val birthYear: String? = null,
    @SerializedName(hairColorField) val hairColor: String? = null,
    @SerializedName(skinColorField) val skinColor: String? = null
)
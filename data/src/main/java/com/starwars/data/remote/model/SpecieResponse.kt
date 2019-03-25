package com.starwars.data.remote.model

import com.google.gson.annotations.SerializedName
import com.starwars.data.remote.service.*

data class SpecieResponse(
    val classification: String? = null,
    val created: String? = null,
    val designation: String? = null,
    val edited: String? = null,
    val films: List<String>? = null,
    val language: String? = null,
    val name: String? = null,
    val people: List<String>? = null,
    val url: String? = null,
    @SerializedName(homeWorldField) val homeWorld: String? = null,
    @SerializedName(averageHeightField) val averageHeight: String? = null,
    @SerializedName(averageLifeSpanField) val averageLifespan: String? = null,
    @SerializedName(eyeColorField) val eyeColors: String? = null,
    @SerializedName(hairColorField) val hairColors: String? = null,
    @SerializedName(skinColorField) val skinColors: String? = null
)
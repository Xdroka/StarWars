package com.starwars.domain.model

data class Specie (
    val id: Int,
    val name: String,
    val classification: String,
    val averageLifespan: String,
    val averageHeight: String,
    val language: String,
    val skinColors: String,
    val eyeColors: String,
    val hairColors: String
)
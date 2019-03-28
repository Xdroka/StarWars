package com.starwars.domain.model

data class Character(
    val id: Int,
    val name: String,
    val gender: String,
    val height: String,
    var birthYear: String,
    val mass: String
)
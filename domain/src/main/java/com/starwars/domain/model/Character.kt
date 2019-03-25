package com.starwars.domain.model

data class Character(
    val id: Int,
    val name: String,
    val gender: String,
    val height: String,
    val homeWorld: String,
    val mass: String
)
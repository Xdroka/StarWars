package com.starwars.domain.mapper

import com.starwars.data.remote.model.CharacterListResponse
import com.starwars.domain.model.Character

fun CharacterListResponse.toMutableList() =
    this.results.map {
        Character(
            id = getId(it.url),
            name = it.name ?: "",
            gender = it.gender ?: "n/a",
            height = it.height ?: "n/a",
            homeWorld = it.homeWorld ?: "n/a",
            mass = it.mass ?: "n/a"
        )
    }.toMutableList()
package com.starwars.domain.mapper

import com.starwars.data.remote.model.SpecieListResponse
import com.starwars.domain.model.Specie

fun SpecieListResponse?.toMutableList(): MutableList<Specie> =
    this?.results?.map {
        Specie(
            name = it.name ?: "",
            classification = it.classification ?: "",
            language = it.language ?: "",
            eyeColors = it.eyeColors ?: "",
            hairColors = it.hairColors ?: "",
            skinColors = it.skinColors ?: "",
            averageHeight = it.averageHeight ?: "",
            averageLifespan = it.averageLifespan ?: ""
        )
    }?.toMutableList() ?: mutableListOf()
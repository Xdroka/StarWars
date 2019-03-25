package com.starwars.domain.mapper

import com.starwars.data.remote.model.SpecieListResponse
import com.starwars.data.remote.model.SpecieResponse
import com.starwars.domain.model.Specie
import java.lang.Exception

fun SpecieListResponse?.toMutableList(): MutableList<Specie> =
    this?.results?.map {
        Specie(
            id = getId(it.url),
            name = it.name ?: "",
            classification = it.classification ?: "",
            language = it.language ?: "",
            eyeColors = it.eyeColors ?: "",
            hairColors = it.hairColors ?: "",
            skinColors = it.skinColors ?: "",
            averageHeight = it.averageHeight ?: "",
            averageLifespan = getAverageLife(it)
        )
    }?.toMutableList() ?: mutableListOf()

private fun getAverageLife(it: SpecieResponse): String {
    return it.averageLifespan?.let { averageLife ->
        if (averageLife == "unknown") averageLife else "$averageLife anos"
    } ?: ""
}

private fun getId(url: String?): Int =
    try {
        url?.split("/")?.let {
            it[it.lastIndex - 1].toInt()
        } ?: -1
    } catch (e: Exception) {
        -1
    }

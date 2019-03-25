package com.starwars.domain.mapper

import com.starwars.data.remote.model.SpecieResponse
import java.lang.Exception

fun getId(url: String?): Int =
    try {
        url?.split("/")?.let {
            it[it.lastIndex - 1].toInt()
        } ?: -1
    } catch (e: Exception) {
        -1
    }

fun getAverageLife(it: SpecieResponse): String {
    return it.averageLifespan?.let { averageLife ->
        if (averageLife == "unknown") averageLife else "$averageLife anos"
    } ?: ""
}
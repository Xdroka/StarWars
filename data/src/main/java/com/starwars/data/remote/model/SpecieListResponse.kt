package com.starwars.data.remote.model

data class SpecieListResponse(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<SpecieResponse>? = null
)
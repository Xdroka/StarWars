package com.starwars.data.remote.model

data class CharacterListResponse(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<CharacterResponse> = listOf()
)


package com.starwars.data.remote.service

import com.starwars.data.remote.model.CharacterListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersWebService {
    @GET(CHARACTER_ENDPOINT)
    fun getCharacters(@Query(PAGE_QUERY) page: Int): Deferred<CharacterListResponse>
}
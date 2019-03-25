package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.CharacterListResponse

interface CharacterRepository{
    suspend fun getCharacters(page: Int): Response<CharacterListResponse>
}
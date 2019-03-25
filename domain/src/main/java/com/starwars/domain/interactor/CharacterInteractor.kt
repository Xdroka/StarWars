package com.starwars.domain.interactor

import com.starwars.data.remote.Response
import com.starwars.domain.model.Character

interface CharacterInteractor {
    suspend fun getCharacters(page: Int): Response<MutableList<Character>>
}
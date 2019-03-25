package com.starwars.domain.interactor

import com.starwars.data.remote.Response
import com.starwars.data.remote.repository.CharacterRepository
import com.starwars.domain.mapper.toMutableList
import com.starwars.domain.model.Character

class CharacterInteractorImpl(
    private val characterRepository: CharacterRepository
): CharacterInteractor {
    override suspend fun getCharacters(page: Int): Response<MutableList<Character>> {
        val response = characterRepository.getCharacters(page)
        return when(response){
            is Response.Failure -> response
            is Response.Success -> Response.Success(response.data.toMutableList())
        }
    }
}
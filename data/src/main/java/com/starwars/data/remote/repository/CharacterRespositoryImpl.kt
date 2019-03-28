package com.starwars.data.remote.repository

import com.starwars.data.remote.Response
import com.starwars.data.remote.model.CharacterListResponse
import com.starwars.data.remote.service.CharactersWebService
import com.starwars.data.remote.service.apiCall

class CharacterRespositoryImpl(
    private val characterService: CharactersWebService
): CharacterRepository {
    private var lastPage: Int? = null

    override suspend fun getCharacters(page: Int): Response<CharacterListResponse> {
        if(lastPage != null){
            lastPage = null
            return Response.Success(CharacterListResponse())
        }
        val response = apiCall { characterService.getCharacters(page) }
        return when(response){
            is Response.Failure -> response
            is Response.Success -> {
                if(response.data.next == null) lastPage = page + 1
                response
            }
        }
    }
}
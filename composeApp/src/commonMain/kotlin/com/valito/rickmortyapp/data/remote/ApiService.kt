package com.valito.rickmortyapp.data.remote

import com.valito.rickmortyapp.data.remote.response.CharacterResponse
import com.valito.rickmortyapp.data.remote.response.CharacterWrapperResponse
import com.valito.rickmortyapp.domain.model.CharacterModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val client: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return client.get(urlString = "/api/character/$id ").body<CharacterResponse>()
    }

    suspend fun getAllCharacters(page: Int): CharacterWrapperResponse {
        return client.get(urlString = "/api/character/") {
            parameter("page", page)
        }.body<CharacterWrapperResponse>()
    }

}


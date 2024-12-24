package com.example.hw4_666.data.network

import com.example.hw4_666.data.model.CharacterResponse
import com.example.hw4_666.data.model.CharacterResultsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterResultsResponse>

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: Int): Response<CharacterResponse>
}
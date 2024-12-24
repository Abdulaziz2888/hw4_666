package com.example.hw4_666.data.repository

import com.example.hw4_666.data.model.CharacterResponse
import com.example.hw4_666.data.network.CharacterApiService

class CharacterRepository(
    private val characterApiService: CharacterApiService
) {

    suspend fun getAllCharacter(): List<CharacterResponse>? {
        return try {
            val response = characterApiService.getAllCharacters()

            if (response.isSuccessful) {
                return response.body()?.characterResponse
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getSingleCharacter(id: Int): CharacterResponse? {
        return try {
            val response = characterApiService.getSingleCharacter(id)

            if (response.isSuccessful) {
                val character = response.body()
                return character
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}
package com.example.hw4_666.data.repository

import com.example.hw4_666.data.model.EpisodeResponse
import com.example.hw4_666.data.network.EpisodeApiService

class EpisodeRepository(
    private val episodeApiService: EpisodeApiService
) {

    suspend fun getAllEpisodes(): List<EpisodeResponse>? {
        return try {
            val response = episodeApiService.getAllEpisodes()

            if (response.isSuccessful) {
                return response.body()?.episodeResponse
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getSingleEpisode(id: Int): EpisodeResponse? {
        return try {
            val response = episodeApiService.getSingleEpisode(id)

            if (response.isSuccessful) {
                val episode = response.body()
                return episode
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}
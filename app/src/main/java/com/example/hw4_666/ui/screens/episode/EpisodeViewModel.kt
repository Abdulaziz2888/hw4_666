package com.example.hw4_666.ui.screens.episode

import androidx.lifecycle.ViewModel
import com.example.hw4_666.data.model.EpisodeResponse
import com.example.hw4_666.data.repository.EpisodeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EpisodeViewModel(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    private val _episodeStateFlow = MutableStateFlow<List<EpisodeResponse>>(emptyList())
    val episodeStateFlow = _episodeStateFlow.asStateFlow()

    suspend fun getAllEpisodes() {
        val episodes = episodeRepository.getAllEpisodes()
        episodes?.let {
            _episodeStateFlow.value = episodes
        }
    }
}
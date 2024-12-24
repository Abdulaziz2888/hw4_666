package com.example.hw4_666.ui.screens.episode.detail

import androidx.lifecycle.ViewModel
import com.example.hw4_666.data.model.EpisodeResponse
import com.example.hw4_666.data.repository.EpisodeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailEpisodeViewModel(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    private val _singleEpisodeStateFlow = MutableStateFlow<EpisodeResponse?>(null)
    val singleEpisodeStateFlow = _singleEpisodeStateFlow.asStateFlow()

    suspend fun getSingleEpisode(id:Int){
        val episode = episodeRepository.getSingleEpisode(id)
        episode?.let {
            _singleEpisodeStateFlow.value = episode
        }
    }

}
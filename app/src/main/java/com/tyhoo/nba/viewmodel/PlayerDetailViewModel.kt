package com.tyhoo.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tyhoo.nba.data.PlayerDetailRepository
import com.tyhoo.nba.data.player.PlayerResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val playerDetailRepository: PlayerDetailRepository
) : ViewModel() {

    suspend fun player(code: String): LiveData<PlayerResponse> {
        return playerDetailRepository.player(code)
    }
}
package com.tyhoo.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tyhoo.nba.api.NBAService
import com.tyhoo.nba.data.player.PlayerResponse
import javax.inject.Inject

class PlayerDetailRepository @Inject constructor(private val service: NBAService) {

    suspend fun player(code: String): LiveData<PlayerResponse> {
        val playerResponse = MutableLiveData<PlayerResponse>()
        try {
            val response = service.player(code)
            playerResponse.postValue(response)
        } catch (e: Exception) {
        }
        return playerResponse
    }
}
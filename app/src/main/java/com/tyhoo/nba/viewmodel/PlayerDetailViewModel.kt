package com.tyhoo.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tyhoo.nba.data.PlayerDetailRepository
import com.tyhoo.nba.data.player.PlayerResponse
import com.tyhoo.nba.data.player.PlayerTeamsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val playerDetailRepository: PlayerDetailRepository
) : ViewModel() {

    suspend fun player(code: String): LiveData<PlayerResponse> {
        return playerDetailRepository.player(code)
    }

    fun seasonStatusList(player: PlayerResponse): List<PlayerTeamsResponse> {
        val list: MutableList<PlayerTeamsResponse> = mutableListOf()

        // 倒序排序
        val reversedList =
            player.payload.player.stats.regularSeasonStat.playerTeams.reversed()

        for (playerTeamsResponse in reversedList) {
            if (playerTeamsResponse.profile != null) {
                list.add(playerTeamsResponse)
            }
        }

        return list
    }
}
package com.tyhoo.nba.viewmodel

import androidx.lifecycle.*
import com.tyhoo.nba.adapter.PlayerSeasonStatusAdapter
import com.tyhoo.nba.data.PlayerDetailRepository
import com.tyhoo.nba.data.player.PlayerPayloadResponse
import com.tyhoo.nba.data.player.PlayerResponse
import com.tyhoo.nba.data.player.PlayerTeamsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val playerDetailRepository: PlayerDetailRepository
) : ViewModel() {

    suspend fun requestData(
        owner: LifecycleOwner,
        code: String,
        playerSeasonStatusAdapter: PlayerSeasonStatusAdapter
    ) {
        playerObserver(owner, code, playerSeasonStatusAdapter)
    }

    private suspend fun playerObserver(
        owner: LifecycleOwner,
        code: String,
        playerSeasonStatusAdapter: PlayerSeasonStatusAdapter
    ) = Observer<PlayerResponse> { player ->
        _payload.value = player.payload
        playerSeasonStatusAdapter.submitList(seasonStatusList(player))
    }.apply {
        player(code).observe(owner, this)
    }

    private suspend fun player(code: String): LiveData<PlayerResponse> {
        return playerDetailRepository.player(code)
    }

    private fun seasonStatusList(player: PlayerResponse): List<PlayerTeamsResponse> {
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

    private val _payload = MutableLiveData<PlayerPayloadResponse>()
    val payload: LiveData<PlayerPayloadResponse>
        get() = _payload
}
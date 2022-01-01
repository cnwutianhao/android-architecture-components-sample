package com.tyhoo.nba.viewmodel

import androidx.lifecycle.*
import com.tyhoo.nba.adapter.PlayersAdapter
import com.tyhoo.nba.data.PlayersRepository
import com.tyhoo.nba.data.db.PlayersEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    playersRepository: PlayersRepository
) : ViewModel() {

    fun requestData(owner: LifecycleOwner, playersAdapter: PlayersAdapter) {
        playersObserver(owner, playersAdapter)
    }

    private fun playersObserver(
        owner: LifecycleOwner, playersAdapter: PlayersAdapter
    ) = Observer<List<PlayersEntity>> { players ->
        playersAdapter.submitList(players)
    }.apply {
        players.observe(owner, this)
    }

    private val players: LiveData<List<PlayersEntity>> = playersRepository.getPlayers().asLiveData()
}
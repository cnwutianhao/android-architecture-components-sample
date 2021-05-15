package com.tyhoo.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tyhoo.nba.data.PlayersRepository
import com.tyhoo.nba.data.db.PlayersEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    playersRepository: PlayersRepository
) : ViewModel() {
    val players: LiveData<List<PlayersEntity>> = playersRepository.getPlayers().asLiveData()
}
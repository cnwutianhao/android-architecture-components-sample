package com.tyhoo.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tyhoo.nba.data.TeamsRepository
import com.tyhoo.nba.data.db.TeamsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    teamsRepository: TeamsRepository
) : ViewModel() {
    val teams: LiveData<List<TeamsEntity>> = teamsRepository.getTeams().asLiveData()
}
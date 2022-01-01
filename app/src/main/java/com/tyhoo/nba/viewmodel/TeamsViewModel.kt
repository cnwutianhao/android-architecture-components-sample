package com.tyhoo.nba.viewmodel

import androidx.lifecycle.*
import com.tyhoo.nba.adapter.TeamsAdapter
import com.tyhoo.nba.data.TeamsRepository
import com.tyhoo.nba.data.db.TeamsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    teamsRepository: TeamsRepository
) : ViewModel() {

    fun requestData(owner: LifecycleOwner, teamsAdapter: TeamsAdapter) {
        teamsObserver(owner, teamsAdapter)
    }

    private fun teamsObserver(
        owner: LifecycleOwner, teamsAdapter: TeamsAdapter
    ) = Observer<List<TeamsEntity>> { teams ->
        teamsAdapter.submitList(teams)
    }.apply {
        teams.observe(owner, this)
    }

    private val teams: LiveData<List<TeamsEntity>> = teamsRepository.getTeams().asLiveData()
}
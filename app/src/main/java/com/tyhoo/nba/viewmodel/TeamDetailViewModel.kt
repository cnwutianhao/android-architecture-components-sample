package com.tyhoo.nba.viewmodel

import androidx.lifecycle.*
import com.tyhoo.nba.data.TeamDetailRepository
import com.tyhoo.nba.data.teamstanding.TeamStandingResponse
import com.tyhoo.nba.data.teamstanding.TeamStandingTeamResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val teamDetailRepository: TeamDetailRepository
) : ViewModel() {

    suspend fun requestData(owner: LifecycleOwner, code: String) {
        teamStandingObserver(owner, code)
    }

    private suspend fun teamStandingObserver(
        owner: LifecycleOwner,
        code: String
    ) = Observer<TeamStandingResponse> { teamStanding ->
        _payloadTeam.value = teamStanding.payload.team
    }.apply {
        teamStanding(code).observe(owner, this)
    }

    private suspend fun teamStanding(code: String): LiveData<TeamStandingResponse> {
        return teamDetailRepository.teamStanding(code)
    }

    private val _payloadTeam = MutableLiveData<TeamStandingTeamResponse>()
    val payloadTeam: LiveData<TeamStandingTeamResponse>
        get() = _payloadTeam
}
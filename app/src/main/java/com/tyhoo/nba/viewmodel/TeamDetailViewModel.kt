package com.tyhoo.nba.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tyhoo.nba.data.TeamDetailRepository
import com.tyhoo.nba.data.teamstanding.TeamStandingResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val teamDetailRepository: TeamDetailRepository
) : ViewModel() {

    suspend fun teamStanding(code: String): LiveData<TeamStandingResponse> {
        return teamDetailRepository.teamStanding(code)
    }
}
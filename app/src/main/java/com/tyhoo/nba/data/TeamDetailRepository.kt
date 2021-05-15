package com.tyhoo.nba.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tyhoo.nba.api.NBAService
import com.tyhoo.nba.data.teamstanding.TeamStandingResponse
import javax.inject.Inject

class TeamDetailRepository @Inject constructor(private val service: NBAService) {

    suspend fun teamStanding(code: String): LiveData<TeamStandingResponse> {
        val teamStandingResponse = MutableLiveData<TeamStandingResponse>()
        try {
            val response = service.teamStanding(code)
            teamStandingResponse.postValue(response)
        } catch (e: Exception) {
        }
        return teamStandingResponse
    }
}
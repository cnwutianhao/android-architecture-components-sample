package com.tyhoo.nba.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tyhoo.nba.api.NBAService
import com.tyhoo.nba.data.db.PlayersDatabase
import com.tyhoo.nba.data.db.PlayersEntity
import com.tyhoo.nba.data.db.TeamsDatabase
import com.tyhoo.nba.data.db.TeamsEntity
import javax.inject.Inject

class SplashRepository @Inject constructor(private val service: NBAService) {

    suspend fun getPlayers(context: Context): LiveData<Boolean> {
        val playersResponse = MutableLiveData<Boolean>()
        return try {
            val players: MutableList<PlayersEntity> = mutableListOf()
            val response = service.players()
            val payloadPlayers = response.payload.players
            payloadPlayers.mapIndexed { i, player ->
                players.add(
                    PlayersEntity(
                        i, player.playerProfile.code, player.playerProfile.displayName,
                        player.playerProfile.jerseyNo, player.playerProfile.playerId,
                        player.playerProfile.position, player.teamProfile.city,
                        player.teamProfile.name
                    )
                )
            }

            val database = PlayersDatabase.getInstance(context)
            database.playerDao().deletePlayerList()
            database.playerDao().insertPlayerList(players)

            playersResponse.postValue(true)
            playersResponse
        } catch (e: Exception) {
            playersResponse.postValue(false)
            playersResponse
        }
    }

    suspend fun getTeams(context: Context): LiveData<Boolean> {
        val teamsResponse = MutableLiveData<Boolean>()
        return try {
            val teams: MutableList<TeamsEntity> = mutableListOf()
            val response = service.teams()
            val easternTeamsResponse = response.payload.listGroups[0].teams
            val westernTeamsResponse = response.payload.listGroups[1].teams

            for (i in easternTeamsResponse.indices) {
                teams.add(
                    TeamsEntity(
                        easternTeamsResponse[i].profile.id,
                        easternTeamsResponse[i].profile.abbr,
                        easternTeamsResponse[i].profile.city,
                        easternTeamsResponse[i].profile.cityEn,
                        easternTeamsResponse[i].profile.code,
                        easternTeamsResponse[i].profile.conference,
                        easternTeamsResponse[i].profile.displayAbbr,
                        easternTeamsResponse[i].profile.displayConference,
                        easternTeamsResponse[i].profile.division,
                        easternTeamsResponse[i].profile.name,
                        easternTeamsResponse[i].profile.nameEn
                    )
                )
            }

            for (i in westernTeamsResponse.indices) {
                teams.add(
                    TeamsEntity(
                        westernTeamsResponse[i].profile.id,
                        westernTeamsResponse[i].profile.abbr,
                        westernTeamsResponse[i].profile.city,
                        westernTeamsResponse[i].profile.cityEn,
                        westernTeamsResponse[i].profile.code,
                        westernTeamsResponse[i].profile.conference,
                        westernTeamsResponse[i].profile.displayAbbr,
                        westernTeamsResponse[i].profile.displayConference,
                        westernTeamsResponse[i].profile.division,
                        westernTeamsResponse[i].profile.name,
                        westernTeamsResponse[i].profile.nameEn
                    )
                )
            }

            val database = TeamsDatabase.getInstance(context)
            database.teamDao().deleteTeamList()
            database.teamDao().insertTeamList(teams)

            teamsResponse.postValue(true)
            teamsResponse
        } catch (e: Exception) {
            teamsResponse.postValue(false)
            teamsResponse
        }
    }
}
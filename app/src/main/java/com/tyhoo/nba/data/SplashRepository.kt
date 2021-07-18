package com.tyhoo.nba.data

import android.content.Context
import com.tyhoo.nba.api.NBAService
import com.tyhoo.nba.data.db.PlayersDatabase
import com.tyhoo.nba.data.db.PlayersEntity
import com.tyhoo.nba.data.db.TeamsDatabase
import com.tyhoo.nba.data.db.TeamsEntity
import javax.inject.Inject

class SplashRepository @Inject constructor(private val service: NBAService) {

    suspend fun getPlayers(context: Context): Boolean {
        try {
            val players: MutableList<PlayersEntity> = mutableListOf()
            val response = service.players()
            val playersResponse = response.payload.players

            playersResponse.mapIndexed { i, playerResponse ->
                players.add(
                    PlayersEntity(
                        i,
                        playerResponse.playerProfile.code,
                        playerResponse.playerProfile.displayName,
                        playerResponse.playerProfile.jerseyNo,
                        playerResponse.playerProfile.playerId,
                        playerResponse.playerProfile.position,
                        playerResponse.teamProfile.city,
                        playerResponse.teamProfile.name
                    )
                )
            }

            val database = PlayersDatabase.getInstance(context)

            //
            database.playerDao().deletePlayerList()

            //
            database.playerDao().insertPlayerList(players)

            return true
        } catch (e: Exception) {
            return false
        }
    }

    suspend fun getTeams(context: Context): Boolean {
        try {
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

            //
            database.teamDao().deleteTeamList()

            //
            database.teamDao().insertTeamList(teams)

            return true
        } catch (e: Exception) {
            return false
        }
    }
}
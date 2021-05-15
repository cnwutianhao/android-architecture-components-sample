package com.tyhoo.nba.data

import com.tyhoo.nba.data.db.TeamsDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamsRepository @Inject constructor(private val teamsDao: TeamsDao) {

    fun getTeams() = teamsDao.getTeams()
}
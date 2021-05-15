package com.tyhoo.nba.data

import com.tyhoo.nba.data.db.PlayersDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayersRepository @Inject constructor(private val playersDao: PlayersDao) {

    fun getPlayers() = playersDao.getPlayers()
}
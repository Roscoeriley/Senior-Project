package com.example.seniorproject.data

import kotlinx.coroutines.flow.Flow

class OfflineLeaguesRepository(private val leagueDao: LeagueDao) : LeaguesRepository {
    override fun getAllLeaguesStream(): Flow<List<League>> = leagueDao.getAllItems()

    override fun getLeagueStream(id: Int): Flow<League?> = leagueDao.getItem(id)

    override suspend fun insertLeague(league: League) = leagueDao.insert(league)

    override suspend fun deleteLeague(league: League) = leagueDao.delete(league)

    override suspend fun updateLeague(league: League) = leagueDao.update(league)
}
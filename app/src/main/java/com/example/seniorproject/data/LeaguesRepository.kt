package com.example.seniorproject.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [League] from a given data source.
 */
interface LeaguesRepository {
    /**
     * Retrieve all the leagues from the the given data source.
     */
    fun getAllLeaguesStream(): Flow<List<League>>

    /**
     * Retrieve a league from the given data source that matches with the [id].
     */
    fun getLeagueStream(id: Int): Flow<League?>

    /**
     * Insert league in the data source
     */
    suspend fun insertLeague(league: League)

    /**
     * Delete league from the data source
     */
    suspend fun deleteLeague(league: League)

    /**
     * Update league in the data source
     */
    suspend fun updateLeague(league: League)
}
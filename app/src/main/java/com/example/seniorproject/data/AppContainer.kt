package com.example.seniorproject.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val itemsRepository: LeaguesRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineLeaguesRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [LeaguesRepository]
     */
    override val itemsRepository: LeaguesRepository by lazy {
        OfflineLeaguesRepository(LeaguesDatabase.getDatabase(context).leagueDao())
    }
}
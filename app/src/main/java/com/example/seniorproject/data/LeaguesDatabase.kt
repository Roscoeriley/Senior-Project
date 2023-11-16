package com.example.seniorproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [League::class], version = 1, exportSchema = false)
abstract class LeaguesDatabase : RoomDatabase() {

    abstract fun leagueDao(): LeagueDao

    companion object {
        @Volatile
        private var Instance: LeaguesDatabase? = null

        fun getDatabase(context: Context): LeaguesDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, LeaguesDatabase::class.java, "league_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
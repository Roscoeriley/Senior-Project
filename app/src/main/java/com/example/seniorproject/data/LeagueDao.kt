package com.example.seniorproject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LeagueDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(league: League)

    @Update
    suspend fun update(league: League)

    @Delete
    suspend fun delete(league: League)

    @Query("SELECT * from leagues WHERE id = :id")
    fun getItem(id: Int): Flow<League>

    @Query("SELECT * from leagues ORDER BY name ASC")
    fun getAllItems(): Flow<List<League>>
}
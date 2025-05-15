package com.example.egzam.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {

    @Query("SELECT * FROM FavouriteJoke")
    fun getAll(): Flow<List<FavouriteJoke>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(joke: FavouriteJoke)

    @Delete
    suspend fun delete(joke: FavouriteJoke)
}
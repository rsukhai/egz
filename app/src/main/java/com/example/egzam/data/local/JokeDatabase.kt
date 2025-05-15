package com.example.egzam.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavouriteJoke::class], version = 1)
abstract class JokeDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokeDao

    companion object {
        @Volatile
        private var INSTANCE: JokeDatabase? = null

        fun getInstance(context: Context): JokeDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    JokeDatabase::class.java,
                    "joke_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
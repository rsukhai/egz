package com.example.egzam.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavouriteJoke(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val joke: String
)
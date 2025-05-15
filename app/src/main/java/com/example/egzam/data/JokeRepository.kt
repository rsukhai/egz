package com.example.egzam.data


import com.example.egzam.data.local.FavouriteJoke
import com.example.egzam.data.local.JokeDao
import com.example.egzam.data.JokeApiService
import kotlinx.coroutines.flow.Flow

class JokeRepository(
    private val api: JokeApiService,
    private val dao: JokeDao
) {
    suspend fun fetchJoke(category: String): String {
        val response = api.getJokeByCategory(
            category = category.lowercase().replace(" ", ""),
            apiKey = "cdb8e61cc1mshe43a89e34c2c37cp18ce1ajsnbd9a2b2106f0"
        )
        return response.data
    }

    fun getFavourites(): Flow<List<FavouriteJoke>> = dao.getAll()

    suspend fun addToFavourites(joke: FavouriteJoke) = dao.insert(joke)

    suspend fun removeFromFavourites(joke: FavouriteJoke) = dao.delete(joke)
}
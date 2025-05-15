package com.example.egzam.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Header
import okhttp3.ResponseBody

data class JokeResponse(
    val data: String
)

interface JokeApiService {
    @GET("{category}")
    suspend fun getJokeByCategory(
        @Path("category") category: String,
        @Header("X-RapidAPI-Key") apiKey: String = "твій_ключ",
        @Header("X-RapidAPI-Host") host: String = "jokes-always.p.rapidapi.com"
    ): JokeResponse
}

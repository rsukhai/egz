package com.example.egzam.data


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitInstance {
    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("x-rapidapi-key", "cdb8e61cc1mshe43a89e34c2c37cp18ce1ajsnbd9a2b2106f0")
                .addHeader("x-rapidapi-host", "jokes-always.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jokes-always.p.rapidapi.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: JokeApiService = retrofit.create(JokeApiService::class.java)
}

package com.example.egzam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.egzam.data.JokeApiService
import com.example.egzam.data.JokeRepository
import com.example.egzam.data.local.JokeDatabase
import com.example.egzam.ui.theme.EgzamTheme
import com.example.egzam.viewmodel.MainViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = JokeDatabase.getInstance(applicationContext)
        val dao = database.jokeDao()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jokes-always.p.rapidapi.com/") // УВАГА: повинен закінчуватися на "/"
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(JokeApiService::class.java)

        val repository = JokeRepository(api, dao)
        val viewModel = MainViewModel(repository)

        setContent {
            EgzamTheme {
                App(viewModel)
            }
        }
    }
}

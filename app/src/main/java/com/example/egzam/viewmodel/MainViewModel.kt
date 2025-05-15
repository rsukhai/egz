package com.example.egzam.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.egzam.data.JokeRepository
import com.example.egzam.data.local.FavouriteJoke
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel(
    private val repository: JokeRepository
) : ViewModel() {

    private val _joke = MutableStateFlow("")
    val joke: StateFlow<String> = _joke.asStateFlow()

    val favourites: StateFlow<List<FavouriteJoke>> = repository.getFavourites()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun loadJoke(category: String) {
        viewModelScope.launch {
            try {
                val newJoke = repository.fetchJoke(category)
                _joke.value = newJoke
            } catch (e: Exception) {
                _joke.value = "Failed to load joke"
            }
        }
    }

    fun addFavourite(category: String, joke: String) {
        viewModelScope.launch {
            repository.addToFavourites(FavouriteJoke(category = category, joke = joke))
        }
    }

    fun removeFavourite(joke: FavouriteJoke) {
        viewModelScope.launch {
            repository.removeFromFavourites(joke)
        }
    }
}
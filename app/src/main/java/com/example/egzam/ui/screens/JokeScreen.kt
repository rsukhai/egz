package com.example.egzam.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.egzam.viewmodel.MainViewModel

@Composable
fun JokeScreen(category: String, viewModel: MainViewModel) {
    val joke by viewModel.joke.collectAsState()

    LaunchedEffect(category) {
        viewModel.loadJoke(category)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = category, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = joke)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { viewModel.addFavourite(category, joke) }) {
            Text("Add to Favourites")
        }
    }
    LaunchedEffect(category) {
        viewModel.loadJoke(category)
    }
    if (category.isBlank()) {
        Text("Invalid category")
        return
    }
}
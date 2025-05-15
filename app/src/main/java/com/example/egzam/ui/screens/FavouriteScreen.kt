package com.example.egzam.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.egzam.data.local.FavouriteJoke
import com.example.egzam.viewmodel.MainViewModel

@Composable
fun FavouriteScreen(viewModel: MainViewModel) {
    val favourites by viewModel.favourites.collectAsState()

    if (favourites.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No favourite jokes")
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(favourites) { joke ->
                FavouriteItem(joke, onRemove = {
                    viewModel.removeFavourite(joke)
                })
            }
        }
    }
}

@Composable
fun FavouriteItem(joke: FavouriteJoke, onRemove: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(joke.category, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(joke.joke)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onRemove,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Remove from Favourites")
        }
    }
}
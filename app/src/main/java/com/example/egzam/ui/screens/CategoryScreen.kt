package com.example.egzam.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val jokeCategoryMap = mapOf(
    "Favourite Jokes" to "favourite",
    "Doctor Jokes" to "doctor",
    "Family Jokes" to "family",
    "Blonde Jokes" to "blonde",
    "Animal Jokes" to "animal",
    "Clean Jokes" to "clean",
    "Yo Mama Jokes" to "yomama",
    "Relationship Jokes" to "relationship",
    "Office Jokes" to "office",
    "Insult Jokes" to "insult",
    "Holiday Jokes" to "holiday",
    "Food Jokes" to "food",
    "Dark Jokes" to "dark",
    "Jokes" to "jokes",
    "Engineer Jokes" to "engineer"
)

private val jokeCategories = jokeCategoryMap.keys.toList()

@Composable
fun CategoryScreen(onCategoryClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(jokeCategories) { displayName ->
            val apiCategory = jokeCategoryMap[displayName] ?: "jokes"
            Text(
                text = displayName,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onCategoryClick(apiCategory) }
                    .padding(8.dp)
            )
        }
    }
}

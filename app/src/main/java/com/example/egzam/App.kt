package com.example.egzam


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.egzam.ui.screens.CategoryScreen
import com.example.egzam.ui.screens.FavouriteScreen
import com.example.egzam.ui.screens.JokeScreen
import com.example.egzam.viewmodel.MainViewModel
import android.net.Uri


@Composable
fun App(viewModel: MainViewModel, navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "category") {
        composable("category") {
            CategoryScreen(onCategoryClick = { category ->
                if (category == "Favourite Jokes") {
                    navController.navigate("favourites")
                } else {
                    navController.navigate("joke/${Uri.encode(category)}")
                }
            })
        }
        composable("joke/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            JokeScreen(category, viewModel)
        }
        composable("favourites") {
            FavouriteScreen(viewModel)
        }
    }
}
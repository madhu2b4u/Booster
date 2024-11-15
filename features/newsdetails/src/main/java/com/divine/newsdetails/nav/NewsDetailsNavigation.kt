package com.divine.newsdetails.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.divine.newsdetails.presentation.NewsDetailsScreen


const val newsUrlArg = "newsUrlArg"

fun NavGraphBuilder.newsDetailsScreen(onNavigateBack: () -> Unit) {
    composable("news/{$newsUrlArg}") { backStackEntry ->
        NewsDetailsScreen(
            onNavigateBack = onNavigateBack,
        )
    }
}

fun NavController.navigateToNewsDetails(newsUrl: String) {
    this.navigate("news/$newsUrl")
}

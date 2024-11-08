package com.divine.home.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.divine.home.HomeScreen

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(
    onNavigateToNews: () -> Unit
) {
    composable(homeRoute) {
        HomeScreen(
            onNavigateToNews = onNavigateToNews
        )
    }
}
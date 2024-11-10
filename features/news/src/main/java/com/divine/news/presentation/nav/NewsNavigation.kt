package com.divine.news.presentation.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.divine.news.presentation.screens.NewsScreen
import com.divine.newsdetails.nav.newsDetailsScreen

const val newsRoute = "news"

fun NavGraphBuilder.newsScreen(
    drawerState: DrawerState,
    navController: NavHostController,
) {

    composable(newsRoute) {
        NewsScreen(
            drawerState = drawerState,
            navController=navController,
        )
    }

    newsDetailsScreen(
        onNavigateBack = { navController.popBackStack() }
    )
}
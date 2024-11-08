package com.divine.news.presentation.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.divine.news.presentation.screens.NewsScreen

const val newsRoute = "news"

fun NavGraphBuilder.newsScreen(
    drawerState: DrawerState,
    onNavigateToArticle: () -> Unit,
) {
    composable(newsRoute) {
        NewsScreen(
            drawerState = drawerState,
            onNavigateToArticle = onNavigateToArticle
        )
    }

}
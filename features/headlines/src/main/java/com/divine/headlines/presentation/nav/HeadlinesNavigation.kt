package com.divine.headlines.presentation.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.divine.headlines.presentation.screens.HeadlinesScreen

const val headLinesRoute = "headlines"

fun NavGraphBuilder.headLinesScreen(
    drawerState: DrawerState,
    navController: NavHostController,
    ) {
    composable(headLinesRoute) {
        HeadlinesScreen(
            drawerState = drawerState,
            navController= navController
        )
    }

}
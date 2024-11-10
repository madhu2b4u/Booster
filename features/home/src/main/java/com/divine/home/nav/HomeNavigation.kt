package com.divine.home.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.divine.home.HomeScreen

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(function: () -> Boolean) {
    composable(homeRoute) {
        HomeScreen()
    }
}
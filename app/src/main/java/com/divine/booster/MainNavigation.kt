package com.divine.booster

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.divine.home.nav.homeRoute
import com.divine.home.nav.homeScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = homeRoute) {
        homeScreen {
            navController.navigateUp()
        }
    }
}
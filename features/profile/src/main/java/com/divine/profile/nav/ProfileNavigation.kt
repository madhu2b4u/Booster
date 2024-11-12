package com.divine.profile.nav

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.divine.profile.ProfileScreen

const val profileRoute = "profile"

fun NavGraphBuilder.profileScreen(
    drawerState: DrawerState,
    navController: NavHostController,
) {
    composable(profileRoute) {
        ProfileScreen(
            drawerState = drawerState,
            navController = navController
        )
    }

}
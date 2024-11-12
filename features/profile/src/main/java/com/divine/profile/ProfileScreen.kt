package com.divine.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.divine.common.CustomAppBar


@Composable
fun ProfileScreen(drawerState: DrawerState, navController: NavHostController) {
    val viewModel: ProfileViewModel = hiltViewModel()
    val userInfo by viewModel.userInfo.collectAsState()

    Scaffold(
        topBar = { CustomAppBar(drawerState = drawerState, title = "Profile") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            userInfo?.let { user ->
                Text("ID: ${user.id}")
                Text("Name: ${user.name}")
                Text("Email: ${user.email}")
            } ?: CircularProgressIndicator()
        }
    }
}

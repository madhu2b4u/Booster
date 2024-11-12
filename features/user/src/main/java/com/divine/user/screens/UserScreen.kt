package com.divine.user.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.divine.common.ui.CustomAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(drawerState: DrawerState, navController: NavHostController) {
    var showModalBottomSheet by remember { mutableStateOf(false) }
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = { CustomAppBar(drawerState = drawerState, title = "User Info") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { showModalBottomSheet = true }) {
                Text("Show Bottom Sheet")
            }

            if (showModalBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showModalBottomSheet = false }
                ) {
                    when (currentStep) {
                        1 -> StepOneContent(
                            onNextClicked = { currentStep = 2 },
                            onCloseClicked = { showModalBottomSheet = false }
                        )

                        2 -> StepTwoContent(
                            onPreviousClicked = { currentStep = 1 },
                            onCloseClicked = { showModalBottomSheet = false }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StepOneContent(onNextClicked: () -> Unit, onCloseClicked: () -> Unit) {
    StepContent(
        title = "Step 1",
        description = "This is the first step in the bottom sheet.",
        onPreviousClicked = null,
        onNextClicked = onNextClicked,
        onCloseClicked = onCloseClicked
    )
}

@Composable
fun StepTwoContent(onPreviousClicked: () -> Unit, onCloseClicked: () -> Unit) {
    StepContent(
        title = "Step 2",
        description = "This is the second step in the bottom sheet.",
        onPreviousClicked = onPreviousClicked,
        onNextClicked = null,
        onCloseClicked = onCloseClicked
    )
}

@Composable
fun StepContent(
    title: String,
    description: String,
    onPreviousClicked: (() -> Unit)? = null,
    onNextClicked: (() -> Unit)? = null,
    onCloseClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(description)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            onPreviousClicked?.let {
                Button(onClick = it) {
                    Text("Previous")
                }
            }
            onCloseClicked.let {
                Button(onClick = it) {
                    Text("Close")
                }
            }
            onNextClicked?.let {
                Button(onClick = it) {
                    Text("Next")
                }
            }
        }
    }
}

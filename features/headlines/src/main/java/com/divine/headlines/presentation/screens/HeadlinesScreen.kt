package com.divine.headlines.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.divine.common.CustomAppBar
import com.divine.common.di.Status
import com.divine.headlines.data.model.Article
import com.divine.headlines.presentation.viewmodel.HeadlinesViewModel

@Composable
fun HeadlinesScreen(
    drawerState: DrawerState,
) {
    val viewModel: HeadlinesViewModel = hiltViewModel()

    val newsState by viewModel.headlinesNews.collectAsState()

    Scaffold(
        topBar = {
            CustomAppBar(
                drawerState = drawerState,
                title = "Headlines"
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (newsState.status) {
                Status.LOADING -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }

                Status.SUCCESS -> {
                    val news = newsState.data

                    LazyColumn {
                        news?.let {
                            items(
                                count = it.size,
                                contentType = { index -> "news" }
                            ) { index ->
                                val article = it[index]
                                NewsItem(article = article) {
                                    /*navController.navigate(
                                        NavigationItem.PostDetails.createRoute(
                                            article.id,
                                            article.title
                                        )
                                    )*/
                                }
                            }
                        }
                    }
                }

                Status.ERROR -> {
                    Text(text = "Error: ${newsState.message}", color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}

@Composable
fun NewsItem(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = article.title, style = MaterialTheme.typography.titleMedium)
            Text(text = article.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

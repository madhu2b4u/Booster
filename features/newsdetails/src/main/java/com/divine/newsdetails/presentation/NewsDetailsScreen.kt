package com.divine.newsdetails.presentation

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailsScreen(
    onNavigateBack: () -> Unit,
) {
    val viewModel: NewsDetailsViewModel = hiltViewModel()

    var webViewCanGoBack by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }
    val articleUrl by viewModel.articleUrl


    BackHandler(enabled = webViewCanGoBack) {
        if (webViewCanGoBack) {
            webViewCanGoBack = false
        } else {
            onNavigateBack()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("News Details") },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

        Box(modifier = Modifier.fillMaxSize()) {
            // WebView content
            articleUrl?.let { url ->
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            webViewClient = object : WebViewClient() {
                                override fun onPageFinished(view: WebView?, url: String?) {
                                    super.onPageFinished(view, url)
                                    isLoading = false
                                }
                            }
                            webChromeClient = WebChromeClient()
                            loadUrl(url)
                        }
                    },
                    modifier = Modifier.fillMaxSize(),
                    update = { webView ->
                        webView.loadUrl(url)
                        webViewCanGoBack = webView.canGoBack()
                    }
                )
            }

            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

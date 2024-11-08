package com.divine.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divine.common.di.Result
import com.divine.news.data.model.Article
import com.divine.news.domain.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _newsArticles = MutableStateFlow<Result<MutableList<Article>>>(Result.loading())
    val newsArticles: StateFlow<Result<List<Article>>> = _newsArticles.asStateFlow()

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                newsUseCase.getNews()
                    .onStart { _newsArticles.value = Result.loading() }
                    .collect { result ->
                        _newsArticles.value = result
                    }
            } catch (e: Exception) {
                _newsArticles.value = Result.error("Failed to fetch news: ${e.message}")
            }
        }
    }
}

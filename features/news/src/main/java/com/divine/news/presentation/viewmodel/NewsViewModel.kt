package com.divine.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.divine.news.data.model.Article
import com.divine.news.domain.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.divine.common.di.Result

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _news = MutableStateFlow<Result<MutableList<Article>>>(Result.loading())
    val posts: StateFlow<Result<List<Article>>> = _news.asStateFlow()

    init {
        fetchNews()
    }


    private fun fetchNews() {
        viewModelScope.launch {
            try {
                newsUseCase.getNews()
                    .onStart { _news.value = Result.loading() }
                    .collect { result ->
                        _news.value = result
                    }
            } catch (e: Exception) {
                _news.value = Result.error("Failed to fetch news: ${e.message}")
            }
        }
    }
}

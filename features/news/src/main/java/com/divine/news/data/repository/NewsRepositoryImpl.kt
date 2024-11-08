package com.divine.news.data.repository

import com.divine.common.di.Result
import com.divine.news.data.model.Article
import com.divine.news.data.source.NewsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource,
) : NewsRepository {

    override suspend fun getNews(): Flow<Result<MutableList<Article>>> = flow {
        emit(Result.loading())
        try {
            val newsList = remoteDataSource.getNews()
            emit(Result.success(newsList))
        } catch (exception: Exception) {
            // If an exception occurs, emit error state
            emit(Result.error(exception.message ?: "", null))
        }
    }
}

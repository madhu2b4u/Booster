package com.divine.news.data.repository

import com.divine.common.di.Result
import com.divine.common.models.Article
import com.divine.news.data.source.NewsLocalDataSource
import com.divine.news.data.source.NewsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource,
) : NewsRepository {

    override suspend fun getNews(): Flow<Result<MutableList<Article>>> = flow {
        emit(Result.loading())
        try {

            var news: List<Article>? = localDataSource.getNews()
            if (news == null) {
                news = remoteDataSource.getNews()
                localDataSource.saveNews(news)
            }
            emit(Result.success(news.toMutableList()))
        } catch (exception: Exception) {
            // If an exception occurs, emit error state
            emit(Result.error(exception.message ?: "", null))
        }
    }
}

package com.divine.headlines.data.repository

import com.divine.common.di.Result
import com.divine.common.models.Article
import com.divine.headlines.data.source.HeadlinesRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HeadlinesRepositoryImpl @Inject constructor(
    private val remoteDataSource: HeadlinesRemoteDataSource,
) : HeadlinesRepository {

    override suspend fun getHeadlines(): Flow<Result<MutableList<Article>>> = flow {
        emit(Result.loading())
        try {
            val newsList = remoteDataSource.getHeadlines()
            emit(Result.success(newsList))
        } catch (exception: Exception) {
            // If an exception occurs, emit error state
            emit(Result.error(exception.message ?: "", null))
        }
    }
}

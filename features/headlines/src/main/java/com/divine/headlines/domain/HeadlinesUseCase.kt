package com.divine.headlines.domain

import com.divine.common.di.Result
import com.divine.common.models.Article
import kotlinx.coroutines.flow.Flow

interface HeadlinesUseCase {

    suspend fun getHeadlines(): Flow<Result<MutableList<Article>>>

}
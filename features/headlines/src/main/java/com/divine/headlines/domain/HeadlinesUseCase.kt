package com.divine.headlines.domain

import com.divine.common.di.Result
import com.divine.headlines.data.model.Article
import kotlinx.coroutines.flow.Flow

interface HeadlinesUseCase {

    suspend fun getHeadlines(): Flow<Result<MutableList<Article>>>

}
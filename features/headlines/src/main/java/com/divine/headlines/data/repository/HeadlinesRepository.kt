package com.divine.headlines.data.repository

import com.divine.common.di.Result
import com.divine.headlines.data.model.Article
import kotlinx.coroutines.flow.Flow

interface HeadlinesRepository {

    suspend fun getHeadlines(): Flow<Result<MutableList<Article>>>

}
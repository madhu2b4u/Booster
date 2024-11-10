package com.divine.news.data.repository

import com.divine.common.di.Result
import com.divine.common.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNews(): Flow<Result<MutableList<Article>>>

}
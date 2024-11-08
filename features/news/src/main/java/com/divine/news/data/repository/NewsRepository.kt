package com.divine.news.data.repository

import com.divine.common.di.Result
import com.divine.news.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNews(): Flow<Result<MutableList<Article>>>

}
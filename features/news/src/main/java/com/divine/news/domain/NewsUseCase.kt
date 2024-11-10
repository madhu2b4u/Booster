package com.divine.news.domain

import com.divine.common.di.Result
import com.divine.common.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {

    suspend fun getNews(): Flow<Result<MutableList<Article>>>

}
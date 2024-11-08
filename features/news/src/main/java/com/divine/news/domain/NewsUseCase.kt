package com.divine.news.domain

import com.divine.common.di.Result
import com.divine.news.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {

    suspend fun getNews(): Flow<Result<MutableList<Article>>>

}
package com.divine.headlines.data.source

import com.divine.common.models.Article

interface HeadlinesRemoteDataSource {

    suspend fun getHeadlines(): MutableList<Article>

}
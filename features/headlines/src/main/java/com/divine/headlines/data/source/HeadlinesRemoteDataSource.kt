package com.divine.headlines.data.source

import com.divine.headlines.data.model.Article

interface HeadlinesRemoteDataSource {

    suspend fun getHeadlines(): MutableList<Article>

}
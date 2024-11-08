package com.divine.news.data.source

import com.divine.news.data.model.Article

interface NewsRemoteDataSource {

    suspend fun getNews(): MutableList<Article>

}
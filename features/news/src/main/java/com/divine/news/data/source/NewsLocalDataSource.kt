package com.divine.news.data.source

import com.divine.common.models.Article


interface NewsLocalDataSource {
    suspend fun getNews(): List<Article>?
    suspend fun saveNews(posts: List<Article>)
}
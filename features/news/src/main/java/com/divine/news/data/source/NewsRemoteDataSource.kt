package com.divine.news.data.source

import com.divine.common.models.Article


interface NewsRemoteDataSource {

    suspend fun getNews(): MutableList<Article>

}
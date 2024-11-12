package com.divine.news.database

import com.divine.common.Mapper
import com.divine.common.database.DbNews
import com.divine.common.models.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class NewsMapper @Inject constructor(val gson: Gson) : Mapper<DbNews, List<Article>> {

    override fun from(e: List<Article>) = DbNews(1, gson.toJson(e))

    override fun to(t: DbNews): List<Article> {
        return gson.fromJson(
            t.posts,
            TypeToken.getParameterized(ArrayList::class.java, Article::class.java).type
        )
    }
}
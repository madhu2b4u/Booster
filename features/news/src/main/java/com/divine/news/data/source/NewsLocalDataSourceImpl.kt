package com.divine.news.data.source

import com.divine.common.database.NewsDao
import com.divine.common.di.qualifiers.IO
import com.divine.common.models.Article
import com.divine.news.database.NewsMapper
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class NewsLocalDataSourceImpl @Inject constructor(
    private val dao: NewsDao,
    private val newsMapper: NewsMapper,
    @IO private val context: CoroutineContext
) : NewsLocalDataSource {

    override suspend fun getNews() = withContext(context) {
        val entity = dao.getNewsFromDatabase()
        if (entity != null)
            newsMapper.to(entity)
        else
            null
    }

    override suspend fun saveNews(posts: List<Article>) {
        withContext(context) {
            val news = newsMapper.from(posts)
            dao.saveNewsToDatabase(news)
        }
    }
}
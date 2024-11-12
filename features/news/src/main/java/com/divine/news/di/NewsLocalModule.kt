package com.divine.news.di

import com.divine.news.data.source.NewsLocalDataSource
import com.divine.news.data.source.NewsLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NewsLocalModule.Binders::class])
@InstallIn(SingletonComponent::class)
class NewsLocalModule {
    @Module
    @InstallIn(SingletonComponent::class)
    interface Binders {
        @Binds
        fun bindsLocalDataSource(
            localDataSourceImpl: NewsLocalDataSourceImpl
        ): NewsLocalDataSource
    }
}
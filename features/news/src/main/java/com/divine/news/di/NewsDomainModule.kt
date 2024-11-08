package com.divine.news.di

import com.divine.news.data.repository.NewsRepository
import com.divine.news.data.repository.NewsRepositoryImpl
import com.divine.news.domain.NewsUseCase
import com.divine.news.domain.NewsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsDomainModule {

    /**
     * Binds the implementation of NewsRepository to its interface.
     *
     * @param repoImpl The concrete implementation of NewsRepository.
     * @return An instance of NewsRepository.
     */

    @Binds
    internal abstract fun bindRepository(
        repoImpl: NewsRepositoryImpl
    ): NewsRepository

    /**
     * Binds the implementation of NewsUseCase to its interface.
     *
     * @param useCaseImpl The concrete implementation of NewsUseCase.
     * @return An instance of NewsUseCase.
     */

    @Binds
    internal abstract fun bindsUseCase(
        useCaseImpl: NewsUseCaseImpl
    ): NewsUseCase

}
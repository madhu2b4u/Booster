package com.divine.news.di

import com.divine.news.data.repository.NewsRepository
import com.divine.news.data.repository.NewsRepositoryImpl
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
     * Binds the implementation of PostUseCase to its interface.
     *
     * @param useCaseImpl The concrete implementation of PostUseCase.
     * @return An instance of PostUseCase.
     */


    @Binds
    internal abstract fun bindsUseCase(
        useCaseImpl: PostsUseCaseImpl
    ): PostsUseCase

}
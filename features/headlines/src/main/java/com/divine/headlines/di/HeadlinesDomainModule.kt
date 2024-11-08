package com.divine.headlines.di

import com.divine.headlines.data.repository.HeadlinesRepository
import com.divine.headlines.data.repository.HeadlinesRepositoryImpl
import com.divine.headlines.domain.HeadlinesUseCase
import com.divine.headlines.domain.HeadlinesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HeadlinesDomainModule {

    /**
     * Binds the implementation of HeadlinesRepository to its interface.
     *
     * @param repoImpl The concrete implementation of HeadlinesRepository.
     * @return An instance of HeadlinesRepository.
     */

    @Binds
    internal abstract fun bindRepository(
        repoImpl: HeadlinesRepositoryImpl
    ): HeadlinesRepository

    /**
     * Binds the implementation of HeadlinesUseCase to its interface.
     *
     * @param useCaseImpl The concrete implementation of HeadlinesUseCase.
     * @return An instance of HeadlinesUseCase.
     */

    @Binds
    internal abstract fun bindsUseCase(
        useCaseImpl: HeadlinesUseCaseImpl
    ): HeadlinesUseCase

}
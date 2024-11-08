package com.divine.headlines.domain

import com.divine.headlines.data.repository.HeadlinesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeadlinesUseCaseImpl @Inject constructor(private val repository: HeadlinesRepository) :
    HeadlinesUseCase {
    override suspend fun getHeadlines() = repository.getHeadlines()
}
package com.divine.profile.domain

import com.divine.common.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : ProfileUseCase {
    override suspend fun getUser() = userRepository.getUserInfo()
}
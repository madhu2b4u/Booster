package com.divine.profile.di

import com.divine.profile.domain.ProfileUseCase
import com.divine.profile.domain.ProfileUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProfileDomainModule {

    @Binds
    internal abstract fun bindsUseCase(
        useCaseImpl: ProfileUseCaseImpl
    ): ProfileUseCase
}
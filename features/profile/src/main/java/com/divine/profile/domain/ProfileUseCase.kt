package com.divine.profile.domain

import com.divine.common.models.UserInfo

interface ProfileUseCase {

    suspend fun getUser(): UserInfo

}
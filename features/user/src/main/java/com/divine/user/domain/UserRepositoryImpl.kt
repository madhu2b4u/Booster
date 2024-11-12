package com.divine.user.domain

import com.divine.common.UserRepository
import com.divine.common.models.UserInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {

    override fun getUserInfo(): UserInfo {
        return UserInfo(
            id = "123", name = "John Doe", email = "john.doe@example.com",
            address = ""
        )
    }
}
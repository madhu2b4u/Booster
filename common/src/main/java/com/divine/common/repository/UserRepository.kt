package com.divine.common.repository

import com.divine.common.models.UserInfo

interface UserRepository {
    fun getUserInfo(): UserInfo
}

package com.divine.common

import com.divine.common.models.UserInfo

interface UserRepository {
    fun getUserInfo(): UserInfo
}

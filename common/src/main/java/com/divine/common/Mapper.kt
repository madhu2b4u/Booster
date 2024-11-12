package com.divine.common

interface Mapper<T, E> {

    fun from(e: E): T

    fun to(t: T): E

}
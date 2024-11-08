package com.divine.news.data.service

import com.divine.common.di.API_KEY
import com.divine.news.data.model.NewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("v2/everything")
    fun getNews(
        @Query("domains") countryCode: String = "nzherald.co.nz",
        @Query("apiKey") apiKey: String = API_KEY
    ): Deferred<Response<NewsResponse>>
}
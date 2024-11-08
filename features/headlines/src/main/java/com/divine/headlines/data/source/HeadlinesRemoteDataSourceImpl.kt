package com.divine.headlines.data.source

import com.divine.common.di.qualifiers.IO
import com.divine.common.exception.NoDataException
import com.divine.headlines.data.source.HeadlinesRemoteDataSource
import com.divine.headlines.data.service.HeadlinesService
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class HeadlinesRemoteDataSourceImpl @Inject constructor(
    private val service: HeadlinesService,
    @IO private val context: CoroutineContext
) : HeadlinesRemoteDataSource {
    override suspend fun getHeadlines() = withContext(context) {
        try {
            val response = service.getHeadlines().await()
            if (response.isSuccessful) {
                response.body()?.articles ?: throw NoDataException("Response body is null")
            } else {
                throw HttpException(response)
            }
        } catch (e: IOException) {
            throw IOException("Network error occurred: ${e.message}", e)
        }
    }
}

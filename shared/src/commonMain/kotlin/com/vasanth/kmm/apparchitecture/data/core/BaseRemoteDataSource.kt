package com.vasanth.kmm.apparchitecture.data.core

import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlin.coroutines.cancellation.CancellationException

/**
 * Base class for all RemoteDataSources.
 */
abstract class BaseRemoteDataSource {

    @Throws(RemoteDataStoreException::class, CancellationException::class)
    protected suspend inline fun <reified T> executeRemoteRequest(block: () -> HttpResponse): T {
        val response = getHttpResponse(block)
        val body = response.body<T>()
        return body
    }

    @Throws(RemoteDataStoreException::class, CancellationException::class)
    protected suspend inline fun getHttpResponse(block: () -> HttpResponse): HttpResponse {
        try {
            val response = block()

            return if (response.status.isSuccess()) {
                response
            } else {
                throw RemoteDataStoreException.ServerException(
                    httpStatusCode = response.status.value,
                    errorBody = response.body()
                )
            }
        } catch (exception: Exception) {
            throw RemoteDataStoreException.NetworkException(
                message = exception.message,
                cause = exception
            )
        }
    }

}
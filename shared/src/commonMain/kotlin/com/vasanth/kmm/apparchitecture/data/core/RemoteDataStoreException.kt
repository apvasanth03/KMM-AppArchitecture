package com.vasanth.kmm.apparchitecture.data.core

/**
 * [RemoteDataStoreException] - Exception thrown from [RemoteDataSource]
 */
sealed class RemoteDataStoreException(
    message: String? = null,
    cause: Throwable? = null
) : Exception(message, cause) {

    // Network Exception (includes NoNetwork, ConnectException, SocketTimeoutException, UnknownHostException)
    class NetworkException(
        message: String? = null,
        cause: Throwable? = null
    ) : RemoteDataStoreException(message, cause)

    // Server Exception (Error from server)
    class ServerException(
        val httpStatusCode: Int,
        val errorBody: String?,
        message: String? = null,
        cause: Throwable? = null
    ) : RemoteDataStoreException(message, cause)
}
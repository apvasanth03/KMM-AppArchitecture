package com.vasanth.kmm.apparchitecture.data.datasource.remote

import com.vasanth.kmm.apparchitecture.data.core.BaseRemoteDataSource
import com.vasanth.kmm.apparchitecture.data.model.User
import com.vasanth.kmm.apparchitecture.data.model.UserListResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class UserRemoteDataSource constructor(
    private val httpClient: HttpClient
) : BaseRemoteDataSource() {

    suspend fun getUsers(page: Int): List<User> {
        val userListResponse: UserListResponse = executeRemoteRequest {
            val url = Url("https://reqres.in/api/users?page=${page}")
            val response = httpClient.request(url = url)
            response
        }
        
        return userListResponse.data
    }
}
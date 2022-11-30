package com.vasanth.kmm.apparchitecture.data.repository

import com.vasanth.kmm.apparchitecture.data.core.BaseRepository
import com.vasanth.kmm.apparchitecture.data.datasource.remote.UserRemoteDataSource
import com.vasanth.kmm.apparchitecture.data.model.User

class UserRepository constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : BaseRepository() {

    // BaseRepository Methods
    override suspend fun clearStore() {
        // NO-OP
    }

    // Public Methods
    suspend fun getUsers(page: Int): List<User> {
        return userRemoteDataSource.getUsers(page = page)
    }
}
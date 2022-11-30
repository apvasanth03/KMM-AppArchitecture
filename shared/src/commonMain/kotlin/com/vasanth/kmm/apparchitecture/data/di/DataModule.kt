package com.vasanth.kmm.apparchitecture.data.di

import com.vasanth.kmm.apparchitecture.data.datasource.remote.UserRemoteDataSource
import com.vasanth.kmm.apparchitecture.data.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    // Http Module
    includes(httpModule)

    // DataSource
    single {
        UserRemoteDataSource(httpClient = get())
    }

    // Repository
    single {
        UserRepository(userRemoteDataSource = get())
    }
}
package com.vasanth.kmm.apparchitecture.domain.di

import com.vasanth.kmm.apparchitecture.di.DEFAULT_DISPATCHER
import com.vasanth.kmm.apparchitecture.domain.usecase.GetUserListUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    // UseCase
    factory {
        GetUserListUseCase(
            userRepository = get(),
            dispatcher = get(qualifier = named(DEFAULT_DISPATCHER))
        )
    }
}
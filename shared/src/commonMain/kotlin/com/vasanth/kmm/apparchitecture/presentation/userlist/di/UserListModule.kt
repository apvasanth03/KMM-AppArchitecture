package com.vasanth.kmm.apparchitecture.presentation.userlist.di

import com.vasanth.kmm.apparchitecture.di.DEFAULT_DISPATCHER
import com.vasanth.kmm.apparchitecture.presentation.userlist.mapper.UserUIMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module

val userListModule = module {
    factory {
        UserUIMapper(
            dispatcher = get(qualifier = named(DEFAULT_DISPATCHER))
        )
    }
}
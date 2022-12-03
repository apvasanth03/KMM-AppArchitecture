package com.vasanth.kmm.apparchitecture.presentation.di

import com.vasanth.kmm.apparchitecture.presentation.userlist.di.userListModule
import org.koin.dsl.module

val presentationModule = module {
    // UserList
    includes(userListModule)
}
package com.vasanth.kmm.apparchitecture.di

import com.vasanth.kmm.apparchitecture.presentation.userlist.viewmodel.UserListViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    factory {
        UserListViewModel(
            getUserListUseCase = get(),
            userUIMapper = get()
        )
    }
}
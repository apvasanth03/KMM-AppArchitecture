package com.vasanth.kmm.apparchitecture.di

import com.vasanth.kmm.apparchitecture.presentation.userlist.viewmodel.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    viewModel {
        UserListViewModel(
            getUserListUseCase = get(),
            userUIMapper = get()
        )
    }
}
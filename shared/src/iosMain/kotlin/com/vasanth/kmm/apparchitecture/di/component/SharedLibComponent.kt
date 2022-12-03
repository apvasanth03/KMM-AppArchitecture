package com.vasanth.kmm.apparchitecture.di.component

import com.vasanth.kmm.apparchitecture.presentation.userlist.viewmodel.UserListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

// Called from Swift
object SharedLibComponent : KoinComponent {

    fun userListViewModel(): UserListViewModel = get()

}
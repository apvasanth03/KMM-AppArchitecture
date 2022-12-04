package com.vasanth.kmm.apparchitecture.di.component

import com.vasanth.kmm.apparchitecture.presentation.userlist.viewmodel.UserListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * [SharedLibComponent] - Used to retrieve shared kotlin dependencies from iOS App.
 * Called from Swift
 */
object SharedLibComponent : KoinComponent {

    fun userListViewModel(): UserListViewModel = get()

}
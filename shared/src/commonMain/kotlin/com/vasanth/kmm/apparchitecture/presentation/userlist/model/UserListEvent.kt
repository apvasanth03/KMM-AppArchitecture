package com.vasanth.kmm.apparchitecture.presentation.userlist.model

sealed interface UserListEvent {

    data class ItemClicked(
        val user: UserUIModel
    ) : UserListEvent
}
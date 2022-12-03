package com.vasanth.kmm.apparchitecture.presentation.userlist.model

sealed interface UserListSideEffect {

    data class NavigateToUserDetailScreen(
        val userID: Long
    ) : UserListSideEffect
}
package com.vasanth.kmm.apparchitecture.presentation.userlist.model

sealed interface UserListUIState {

    object Loading : UserListUIState

    data class Data(
        val users: List<UserUIModel>
    ) : UserListUIState

    object Error : UserListUIState
}

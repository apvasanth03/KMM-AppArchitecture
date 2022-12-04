package com.vasanth.kmm.apparchitecture.presentation.userlist.viewmodel

import com.vasanth.kmm.apparchitecture.data.model.User
import com.vasanth.kmm.apparchitecture.domain.core.Result
import com.vasanth.kmm.apparchitecture.domain.usecase.GetUserListUseCase
import com.vasanth.kmm.apparchitecture.presentation.core.BaseViewModel
import com.vasanth.kmm.apparchitecture.presentation.userlist.mapper.UserUIMapper
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserListEvent
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserListSideEffect
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserListUIState
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserListViewModel constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val userUIMapper: UserUIMapper
) : BaseViewModel<UserListUIState, UserListEvent, UserListSideEffect>() {

    // Properties
    override val _uiState: MutableStateFlow<UserListUIState> =
        MutableStateFlow(value = UserListUIState.Loading)

    // Initialization
    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            val param = GetUserListUseCase.Param(page = 1)
            val result = getUserListUseCase.invoke(parameters = param)
            when (result) {
                is Result.Success -> {
                    loadUsersSuccess(users = result.data)
                }
                is Result.Error -> {
                    loadUsersFailure()
                }
            }
        }
    }

    private suspend fun loadUsersSuccess(users: List<User>) {
        val uiModels = users.map {
            userUIMapper(input = it)
        }
        _uiState.update { UserListUIState.Data(users = uiModels) }
    }

    private fun loadUsersFailure() {
        _uiState.update { UserListUIState.Error }
    }

    // Handle Event
    override fun handleEvent(event: UserListEvent) {
        when (event) {
            is UserListEvent.ItemClicked -> {
                onItemClicked(userUIModel = event.user)
            }
        }
    }

    private fun onItemClicked(userUIModel: UserUIModel) {
        sendSideEffect(
            UserListSideEffect.NavigateToUserDetailScreen(userID = userUIModel.id)
        )
    }
}
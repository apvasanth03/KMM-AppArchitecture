package com.vasanth.kmm.apparchitecture.android.ui.userlist.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.KMMAppArchitectureTheme
import com.vasanth.kmm.apparchitecture.presentation.userlist.viewmodel.UserListViewModel

@Composable
fun UserListScreen() {
    val viewModel: UserListViewModel = viewModel()

    KMMAppArchitectureTheme {
        val state = viewModel.uiState.collectAsState().value
        UserListScreenContent(
            state = state,
            handleEvent = viewModel::handleEvent
        )
    }
}
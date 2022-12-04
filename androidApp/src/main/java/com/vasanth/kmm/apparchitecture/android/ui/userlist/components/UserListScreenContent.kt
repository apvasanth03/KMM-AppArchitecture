package com.vasanth.kmm.apparchitecture.android.ui.userlist.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.KMMAppArchitectureTheme
import com.vasanth.kmm.apparchitecture.android.ui.userlist.components.data.UserListData
import com.vasanth.kmm.apparchitecture.android.ui.userlist.components.error.UserListError
import com.vasanth.kmm.apparchitecture.android.ui.userlist.components.loading.UserListLoading
import com.vasanth.kmm.apparchitecture.android.ui.userlist.components.sampledata.UserListSampleData
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserListEvent
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserListUIState

@Composable
fun UserListScreenContent(
    state: UserListUIState,
    handleEvent: (event: UserListEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (state) {
            UserListUIState.Loading -> {
                UserListLoading()
            }

            is UserListUIState.Data -> {
                UserListData(
                    users = state.users,
                    onItemClicked = { user ->
                        handleEvent(UserListEvent.ItemClicked(user = user))
                    }
                )
            }

            UserListUIState.Error -> {
                UserListError()
            }
        }
    }
}

// region PREVIEW
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListScreenContent() {
    KMMAppArchitectureTheme {
        UserListScreenContent(
            state = UserListSampleData.createDataUIState(),
            handleEvent = { }
        )
    }
}
// endregion
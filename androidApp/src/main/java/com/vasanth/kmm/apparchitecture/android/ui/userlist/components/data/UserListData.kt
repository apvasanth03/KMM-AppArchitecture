package com.vasanth.kmm.apparchitecture.android.ui.userlist.components.data

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.KMMAppArchitectureTheme
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.Space_12
import com.vasanth.kmm.apparchitecture.android.ui.userlist.components.sampledata.UserListSampleData
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserUIModel

@Composable
fun UserListData(
    users: List<UserUIModel>,
    onItemClicked: (UserUIModel) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(Space_12)
    ) {
        items(users) { user ->
            UserItem(
                user = user
            ) {
                onItemClicked(user)
            }

            Spacer(modifier = Modifier.height(Space_12))
        }
    }
}

// region Preview
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListLoading() {
    KMMAppArchitectureTheme {
        Surface {
            UserListData(
                users = UserListSampleData.createUserUIModels(),
                onItemClicked = {}
            )
        }
    }
}
// endregion

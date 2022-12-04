package com.vasanth.kmm.apparchitecture.android.ui.userlist.components.data

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.KMMAppArchitectureTheme
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.Space_12
import com.vasanth.kmm.apparchitecture.android.ui.userlist.components.sampledata.UserListSampleData
import com.vasanth.kmm.apparchitecture.presentation.userlist.model.UserUIModel

@Composable
fun UserItem(
    user: UserUIModel,
    onClicked: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .clickable { onClicked() }
                .padding(Space_12),
        ) {
            Text(
                modifier = Modifier,
                text = user.name,
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                modifier = Modifier,
                text = user.email,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

// region Preview
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListScreenContent() {
    KMMAppArchitectureTheme {
        UserItem(
            user = UserListSampleData.createUserUIModel(id = 1L),
            onClicked = {}
        )
    }
}
// endregion
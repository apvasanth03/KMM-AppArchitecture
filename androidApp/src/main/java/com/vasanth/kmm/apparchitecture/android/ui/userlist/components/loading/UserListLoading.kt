package com.vasanth.kmm.apparchitecture.android.ui.userlist.components.loading

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.KMMAppArchitectureTheme

@Composable
fun UserListLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

// region Preview
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListLoading() {
    KMMAppArchitectureTheme {
        Surface {
            UserListLoading()
        }
    }
}
// endregion

package com.vasanth.kmm.apparchitecture.android.ui.userlist.components.error

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vasanth.kmm.apparchitecture.android.R
import com.vasanth.kmm.apparchitecture.android.ui.common.components.error.ErrorItem
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.KMMAppArchitectureTheme

@Composable
fun UserListError() {
    ErrorItem(
        modifier = Modifier.fillMaxSize(),
        image = rememberVectorPainter(image = Icons.Outlined.Warning),
        title = stringResource(id = R.string.unknown_error_title),
        subTitle = stringResource(id = R.string.unknown_error_subtitle),
    )
}

// region Preview
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListError() {
    KMMAppArchitectureTheme {
        Surface {
            UserListError()
        }
    }
}
// endregion
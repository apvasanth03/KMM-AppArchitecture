package com.vasanth.kmm.apparchitecture.android.ui.common.components.error

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vasanth.kmm.apparchitecture.android.R
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.KMMAppArchitectureTheme
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.Space_12
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.Space_2
import com.vasanth.kmm.apparchitecture.android.ui.common.theme.Space_4

@Composable
fun ErrorItem(
    image: Painter,
    title: String,
    modifier: Modifier = Modifier,
    imageTint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    subTitle: String? = null,
    retryText: String? = stringResource(id = R.string.try_again),
    onRetry: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .padding(Space_12),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(84.dp),
            painter = image,
            contentDescription = null,
            tint = imageTint
        )

        Text(
            modifier = Modifier.padding(top = Space_4),
            text = title,
            style = MaterialTheme.typography.body2
        )

        subTitle?.let {
            Text(
                modifier = Modifier.padding(top = Space_2),
                text = it,
                style = MaterialTheme.typography.caption
            )
        }

        retryText?.let {
            TextButton(
                modifier = Modifier.padding(top = Space_12),
                onClick = { onRetry?.invoke() }
            ) {
                Text(text = it)
            }
        }
    }
}

// region PREVIEW
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewErrorItem() {
    KMMAppArchitectureTheme {
        Surface {
            ErrorItem(
                modifier = Modifier.fillMaxSize(),
                image = rememberVectorPainter(image = Icons.Outlined.Warning),
                title = "Unexpected Error",
                subTitle = "Couldn\\'t load due to technical error"
            )
        }
    }
}
// endregion

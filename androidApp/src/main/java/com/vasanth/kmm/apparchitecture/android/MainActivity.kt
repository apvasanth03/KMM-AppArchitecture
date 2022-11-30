package com.vasanth.kmm.apparchitecture.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.vasanth.kmm.apparchitecture.Greeting
import com.vasanth.kmm.apparchitecture.data.model.User
import com.vasanth.kmm.apparchitecture.domain.core.Result
import com.vasanth.kmm.apparchitecture.domain.usecase.GetUserListUseCase
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(Greeting().greeting())
                }
            }
        }

        getUserList()
    }

    // Test Shared UseCase
    private val getUserListUseCase: GetUserListUseCase by inject()
    private val TAG = "GET_USER_LIST"
    private fun getUserList() {
        lifecycleScope.launch {
            val param = GetUserListUseCase.Param(page = 1)
            val result = getUserListUseCase.invoke(parameters = param)
            when (result) {
                is Result.Success -> {
                    getUserListSuccess(users = result.data)
                }
                is Result.Error -> {
                    getUserListFailure(exception = result.exception)
                }
            }
        }
    }

    private fun getUserListSuccess(users: List<User>) {
        Log.i(TAG, "------------ getUserListSuccess ---------------")
        Log.i(TAG, users.toString())
    }

    private fun getUserListFailure(exception: Exception) {
        Log.i(TAG, "------------ getUserListFailure ---------------")
        exception.printStackTrace()
    }
}

@Composable
fun Greeting(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Hello, Android!")
    }
}

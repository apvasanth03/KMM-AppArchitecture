package com.vasanth.kmm.apparchitecture.presentation.core

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual abstract class ViewModel {

    // Actual declaration
    actual val viewModelScope = MainScope()

    protected actual open fun onCleared() {
    }

    fun clear() {
        onCleared()
        viewModelScope.cancel()
    }
}
package com.vasanth.kmm.apparchitecture.presentation.core

import androidx.lifecycle.ViewModel as AndroidXViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual abstract class ViewModel : AndroidXViewModel() {

    // Actual declaration
    actual val viewModelScope = androidXViewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}
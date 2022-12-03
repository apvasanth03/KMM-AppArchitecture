package com.vasanth.kmm.apparchitecture.presentation.core

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {

    val viewModelScope: CoroutineScope

    protected open fun onCleared()
}
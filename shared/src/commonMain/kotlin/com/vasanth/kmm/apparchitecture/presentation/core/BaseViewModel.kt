package com.vasanth.kmm.apparchitecture.presentation.core

import com.vasanth.kmm.apparchitecture.common.helper.concurrency.FlowAdapter
import com.vasanth.kmm.apparchitecture.common.helper.concurrency.asCallbacks
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<STATE : Any, EVENT : Any, SIDEEFECT : Any> : ViewModel() {

    // region Variable Declaration
    protected abstract val _uiState: MutableStateFlow<STATE>
    protected val _sideEffect = Channel<SIDEEFECT>(Channel.BUFFERED)

    val uiState: StateFlow<STATE> by lazy { _uiState }
    val sideEffect: Flow<SIDEEFECT> by lazy { _sideEffect.receiveAsFlow() }

    // Exposes [FlowAdapter] from the [Flow] to make it easier to interact with from Swift.
    val uiStateAsCallback: FlowAdapter<STATE> by lazy { uiState.asCallbacks(viewModelScope) }
    val sideEffectAsCallback: FlowAdapter<SIDEEFECT> by lazy { sideEffect.asCallbacks(viewModelScope) }
    // endregion

    // region Abstract Members.
    abstract fun handleEvent(event: EVENT)
    // endregion

    // region Helper Methods
    protected fun sendSideEffect(sideEffect: SIDEEFECT) {
        viewModelScope.launch {
            _sideEffect.send(sideEffect)
        }
    }
    // endregion
}
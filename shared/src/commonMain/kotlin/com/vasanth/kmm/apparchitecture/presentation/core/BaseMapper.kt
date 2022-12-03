package com.vasanth.kmm.apparchitecture.presentation.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Executes Mapper logic asynchronously using Coroutines.
 */
abstract class BaseMapper<in INPUT, OUTPUT>(protected val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(input: INPUT): OUTPUT {
        return withContext(dispatcher) {
            map(input)
        }
    }

    protected abstract suspend fun map(input: INPUT): OUTPUT
}
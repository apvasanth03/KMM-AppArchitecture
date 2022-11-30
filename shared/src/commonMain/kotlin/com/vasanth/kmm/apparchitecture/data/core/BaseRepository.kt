package com.vasanth.kmm.apparchitecture.data.core

/**
 * Base class for all Repositories.
 */
abstract class BaseRepository {

    abstract suspend fun clearStore()
}
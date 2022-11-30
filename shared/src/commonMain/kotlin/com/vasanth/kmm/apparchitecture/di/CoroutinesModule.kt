package com.vasanth.kmm.apparchitecture.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val DEFAULT_DISPATCHER = "DEFAULT_DISPATCHER"
const val MAIN_DISPATCHER = "MAIN_DISPATCHER"

val coroutinesModule = module {
    single(qualifier = named(DEFAULT_DISPATCHER)) {
        Dispatchers.Default
    }

    single(qualifier = named(MAIN_DISPATCHER)) {
        Dispatchers.Main
    }
}
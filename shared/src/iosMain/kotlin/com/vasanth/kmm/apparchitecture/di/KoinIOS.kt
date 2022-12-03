package com.vasanth.kmm.apparchitecture.di

import org.koin.core.context.startKoin

fun initKoinIOS() {
    startKoin {
        modules(sharedModule())
    }
}
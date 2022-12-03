package com.vasanth.kmm.apparchitecture.di

import com.vasanth.kmm.apparchitecture.data.di.dataModule
import com.vasanth.kmm.apparchitecture.domain.di.domainModule
import com.vasanth.kmm.apparchitecture.presentation.di.presentationModule
import org.koin.core.module.Module

fun sharedModule(): List<Module> {
    val modules = buildList {
        // Common
        add(coroutinesModule)

        // Platform
        add(platformModule)

        // Data
        add(dataModule)

        // Domain
        add(domainModule)

        // Presentation
        add(presentationModule)
    }

    return modules
}
package com.vasanth.kmm.apparchitecture.di

import com.vasanth.kmm.apparchitecture.data.di.dataModule
import com.vasanth.kmm.apparchitecture.domain.di.domainModule
import org.koin.core.module.Module

fun sharedModule(): List<Module> {
    val modules = buildList {
        // Common
        add(coroutinesModule)

        // Data
        add(dataModule)

        // Domain
        add(domainModule)
    }
    
    return modules
}
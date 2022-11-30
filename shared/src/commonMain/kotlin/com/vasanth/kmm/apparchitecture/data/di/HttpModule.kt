package com.vasanth.kmm.apparchitecture.data.di

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val httpModule = module {

    single {
        val json = Json {
            isLenient = true
            ignoreUnknownKeys = true
            prettyPrint = false
            encodeDefaults = true
            allowSpecialFloatingPointValues = true
            allowStructuredMapKeys = true
            useArrayPolymorphism = false
        }
        json
    }

    single {
        val httpClient = HttpClient {
            install(Logging)
            install(ContentNegotiation) {
                json(json = get())
            }
        }
        httpClient
    }
}
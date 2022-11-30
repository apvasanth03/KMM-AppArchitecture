object Dependencies {
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    val ktorClientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    val ktorSerializationKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    val ktorClientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    val ktorClientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"

    val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
}
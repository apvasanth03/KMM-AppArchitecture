object Dependencies {
    // Common
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    val ktorClientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val ktorClientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    val ktorSerializationKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    val ktorClientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    val ktorClientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"

    val koinCore = "io.insert-koin:koin-core:${Versions.koin}"

    // Android
    var activityKtx = "androidx.activity:activity:${Versions.activity}"
    var activityCompose = "androidx.activity:activity-compose:${Versions.activity}"
    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    val composeMaterial = "androidx.compose.material:material"
    val composeUITooling = "androidx.compose.ui:ui-tooling"
    val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val koinAndroid = "io.insert-koin:koin-android:${Versions.koinAndroid}"
}
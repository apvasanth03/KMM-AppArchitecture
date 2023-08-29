import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

@Suppress("DSL_SCOPE_VIOLATION", "ForbiddenComment") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        // Common
        val commonMain by getting {
            dependencies {
                // Kotlin
                implementation(libs.coroutines)
                implementation(libs.ktorClientCore)
                implementation(libs.ktorClientLogging)
                implementation(libs.ktorClientContentNegotiation)
                implementation(libs.ktorSerializationKotlinxJson)
                implementation(libs.koinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        // Andorid
        val androidMain by getting {
            dependencies {
                implementation(libs.ktorClientOkhttp)
                implementation(libs.koinAndroid)
                implementation(libs.viewModelKtx)
            }
        }

        // iOS
        val iosMain by getting {
            dependencies {
                implementation(libs.ktorClientDarwin)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }

        val iosTest by getting
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
        }
    }


}

android {
    namespace = "com.vasanth.kmm.apparchitecture"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
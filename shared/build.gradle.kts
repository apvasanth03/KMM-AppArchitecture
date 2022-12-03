plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version (Versions.kotlin)
}

kotlin {
    android()

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
                implementation(Dependencies.coroutines)

                implementation(Dependencies.ktorClientCore)
                implementation(Dependencies.ktorClientLogging)
                implementation(Dependencies.ktorClientContentNegotiation)
                implementation(Dependencies.ktorSerializationKotlinxJson)
                implementation(Dependencies.koinCore)
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
                implementation(Dependencies.ktorClientOkhttp)
                implementation(Dependencies.koinAndroid)
                implementation(Dependencies.viewModelKtx)
            }
        }
        val androidTest by getting

        // iOS
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(Dependencies.ktorClientDarwin)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.vasanth.kmm.apparchitecture"
    compileSdk = ConfigData.compileSdkVersion
    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
    }
}
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.vasanth.kmm.apparchitecture.android"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.vasanth.kmm.apparchitecture.android"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Dependencies.activityKtx)
    implementation(Dependencies.fragmentKtx)
    val composeBom = platform(Dependencies.composeBom)
    implementation(composeBom)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeUITooling)
    implementation(Dependencies.composeUIToolingPreview)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.viewModelCompose)
    implementation(Dependencies.navigationFragmentKtx)
    implementation(Dependencies.navigationUIKtx)

    implementation(Dependencies.koinAndroid)
}
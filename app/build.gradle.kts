plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.divine.booster"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.divine.booster"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {

    implementation(project(":common"))
    implementation(project(":features:home"))
    implementation(project(":features:news"))

    //hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    testImplementation(libs.androidx.core.testing)
    annotationProcessor(libs.androidx.room.compiler)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.hilt.android.testing)
    kapt (libs.hilt.android.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.hilt.navigation.compose)

    // Mockito for mocking
    testImplementation(libs.mockito.core)

    // Mockito Kotlin extension for easier usage with Kotlin
    testImplementation(libs.mockito.kotlin)

    // Truth for easier assertions
    testImplementation(libs.truth)

    // Hilt for Dependency Injection in tests
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler.v244)

    // Coroutines test library
    testImplementation(libs.kotlinx.coroutines.test)

    // Hilt testing requires AndroidX Test libraries
    androidTestImplementation(libs.androidx.core)
    androidTestImplementation(libs.androidx.junit)

    // For running tests on AndroidX components
    androidTestImplementation(libs.androidx.core.testing)

    // AndroidX Test Runner for running tests
    androidTestImplementation(libs.androidx.runner)

    testImplementation(libs.robolectric)

    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)

    //retrofit libraries for network calls
    implementation(libs.retrofit)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)
    implementation(libs.logging.interceptor)
    implementation(libs.adapter.rxjava)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.mockwebserver)
}
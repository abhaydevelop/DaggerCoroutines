plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.kapt")  // ✅ Correct way to apply kapt
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.daggerandcoroutines"
    compileSdk = 34

    defaultConfig {

        ndk {
            abiFilters += listOf("armeabi-v7a", "arm64-v8a")
        }
        applicationId = "com.example.daggerandcoroutines"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            isShrinkResources = false

            buildConfigField("String", "BASE_URL", project.findProperty("PROD_BASE_URL") as String? ?: "")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
                "proguard-rules-epubear.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = false
            buildConfigField("String", "BASE_URL", project.findProperty("QA_BASE_URL") as String? ?: "")
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
                "proguard-rules-epubear.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    // Lifecycle & ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Retrofit & Gson
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    implementation("androidx.activity:activity:1.9.0") // ✅ Compatible with SDK 34
    implementation(libs.androidx.constraintlayout)
    kapt("com.google.dagger:hilt-android-compiler:2.50")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
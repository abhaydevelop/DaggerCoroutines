// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Root-level Gradle file (Project-level)
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}

plugins {
    kotlin("android") version "1.9.0" apply false
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
}


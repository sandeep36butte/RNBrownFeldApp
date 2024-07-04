// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.facebook.react") apply false
    alias(libs.plugins.android.library) apply false
}


buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.facebook.react:react-native-gradle-plugin")
        // classpath("com.google.gms:google-services:4.3.15")
    }
}
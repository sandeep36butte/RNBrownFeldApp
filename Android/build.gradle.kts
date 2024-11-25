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
    }
//    extra.apply {
//        set("buildToolsVersion", "35.0.0")
//        set("minSdkVersion", 24)
//        set("compileSdkVersion", 35)
//        set("targetSdkVersion", 34)
//        set("ndkVersion", "26.1.10909125")
//        set("kotlinVersion", "1.9.24")
//    }
}

apply(plugin = "com.facebook.react.rootproject")
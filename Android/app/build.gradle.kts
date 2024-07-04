plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.facebook.react")
}

val reactNativeDirPath = "../../ReactNative/node_modules/react-native"
apply(from = "../../ReactNative/node_modules/@react-native-community/cli-platform-android/native_modules.gradle")
val applyNativeModulesAppBuildGradle: groovy.lang.Closure<Any> by extra
applyNativeModulesAppBuildGradle(project)

react {
    root = file("../../ReactNative")
    reactNativeDir = file(reactNativeDirPath)
    cliFile = file("$reactNativeDirPath/cli.js")
    codegenDir = file("../../ReactNative/node_modules/@react-native/codegen")
    entryFile = file("../../ReactNative/index.js")
}

val enableSeparateBuildPerCPUArchitecture = true

rootProject.ext.set("minSdkVersion", 23)
rootProject.ext.set("kotlinVersion", "1.8.20")
rootProject.ext.set("compileSdkVersion", 33)
rootProject.ext.set("targetSdkVersion", 33)
//rootProject.ext.set("newArchEnabled", newArchEnabled)
rootProject.ext.set("buildToolsVersion", "34.0.0")
rootProject.ext.set("REACT_NATIVE_NODE_MODULES_DIR", file(reactNativeDirPath))
rootProject.ext.set("reactNativeAndroidRoot", file("../../ReactNative"))

android {
    namespace = "com.example.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "JS_MAIN_MODULE_NAME", "\"index\"")
        buildConfigField("String", "BUNDLE_ASSET_NAME", "\"index.android.bundle\"")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    splits {
        abi {
            isEnable = true
            reset()
            isUniversalApk = false
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    sourceSets {
        getByName("main") {
            java {
                srcDirs("src/main/java", "src/main/java/com/example/activities")
            }
        }
    }
}

dependencies {

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
    implementation("com.facebook.react:react-android")
    implementation("com.facebook.react:hermes-android")
}
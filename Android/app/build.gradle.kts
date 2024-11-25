plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.facebook.react")
}

val reactNativeDirPath = "../../ReactNative/node_modules/react-native"

react {
    root = file("../../ReactNative")
    reactNativeDir = file(reactNativeDirPath)
    cliFile = file("$reactNativeDirPath/cli.js")
    codegenDir = file("../../ReactNative/node_modules/@react-native/codegen")
    entryFile = file("../../ReactNative/index.js")
    autolinkLibrariesWithApp()
}

println("newArchEnabled12345: ${project.property("newArchEnabled").toString().toBoolean()}")

val enableSeparateBuildPerCPUArchitecture = true
val enableProguardInReleaseBuilds = false
rootProject.ext.set("minSdkVersion", 24)
rootProject.ext.set("kotlinVersion", "1.9.24")
rootProject.ext.set("compileSdkVersion", 35)
rootProject.ext.set("targetSdkVersion", 34)
rootProject.ext.set("buildToolsVersion", "35.0.0")
rootProject.ext.set("REACT_NATIVE_NODE_MODULES_DIR", file(reactNativeDirPath))
rootProject.ext.set("reactNativeAndroidRoot", file("../../ReactNative"))
rootProject.ext.set("hermesEnabled", "true");
rootProject.ext.set("newArchEnabled", "true");

android {
    namespace = "com.example.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example"
        minSdk = 24
        targetSdk = 34
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
        debug {  }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    android {
        ndkVersion = "26.1.10909125"
        sourceSets {
            getByName("main") {
                java.srcDirs("src/main/java/com/example/android/generated")
            }
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
        kotlinCompilerExtensionVersion = "1.5.14"
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


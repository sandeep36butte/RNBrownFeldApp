pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("../reactnative/node_modules/@react-native/gradle-plugin")
}
plugins { id("com.facebook.react.settings") }
extensions.configure<com.facebook.react.ReactSettingsExtension> {
    autolinkLibrariesFromCommand() // Ensure this method exists in ReactSettingsExtension
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        jcenter()
        mavenLocal()
        mavenCentral()
    }
}

rootProject.name = "Android"
include(":app")
includeBuild("../reactnative/node_modules/@react-native/gradle-plugin")
apply(from = "../reactnative/node_modules/@react-native-community/cli-platform-android/native_modules.gradle")
// val applyNativeModulesSettingsGradle: groovy.lang.Closure<Any> by extra
// applyNativeModulesSettingsGradle(settings)
 
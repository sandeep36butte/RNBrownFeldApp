package com.example.android

import android.app.Application
import android.support.v4.os.IResultReceiver
import android.util.Log
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost
import com.facebook.soloader.SoLoader
import com.facebook.react.defaults.DefaultReactHost;
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.soloader.OpenSourceMergedSoMapping
import com.example.android.RNTurboModulePackage

class AppController : Application(), ReactApplication {


    override val reactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {
            override fun getPackages(): List<ReactPackage> {
                Log.d("ReactNative", "GetPackages")
                val packages = PackageList(this).packages.toMutableList()
                packages.add(RNTurboModulePackage());
                return packages
            }

            override fun getJSMainModuleName(): String = "index"

            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

            override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
            override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED
        }

    override fun onCreate() {
        super.onCreate()
        instance = this
        SoLoader.init(this,  OpenSourceMergedSoMapping)
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            Log.d("ReactNative","Loading from new Architecture")
            // If you opted-in for the New Architecture, we load the native entry point for this app.
            load()
        }
    }

    fun getReactInstanceManager(): ReactInstanceManager {
        return reactNativeHost.reactInstanceManager
    }


    companion object {
        lateinit var tracker: IResultReceiver.Default
        private lateinit var instance: AppController

        fun getInstance(): AppController {
            return instance
        }
    }

    override val reactHost: ReactHost
        get() = getDefaultReactHost(applicationContext, reactNativeHost)

}
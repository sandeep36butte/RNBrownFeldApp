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
import com.facebook.soloader.SoLoader
import com.facebook.react.defaults.DefaultReactHost;

class AppController : Application(), ReactApplication {


    private val mReactNativeHost = object : ReactNativeHost(this) {
        override fun getUseDeveloperSupport(): Boolean {
            Log.d("ReactNative", "GetDebug")
            return BuildConfig.DEBUG
        }

        override fun getPackages(): List<ReactPackage> {
            Log.d("ReactNative", "GetPackages")
            val packages = PackageList(this).packages.toMutableList()
            return packages
        }

        override fun getJSBundleFile(): String {
            Log.d("ReactNative", "GetBundle")
            return "assets://index.android.bundle"
        }

        override fun getJSMainModuleName(): String {
            Log.d("ReactNative", "GetModule")
            return "index"
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        SoLoader.init(this, /* native exopackage */ false)
    }

    fun getReactInstanceManager(): ReactInstanceManager {
        return mReactNativeHost.reactInstanceManager
    }


    companion object {
        lateinit var tracker: IResultReceiver.Default
        private lateinit var instance: AppController

        fun getInstance(): AppController {
            return instance
        }
    }

    override val reactHost: ReactHost
        get() = DefaultReactHost.getDefaultReactHost(applicationContext, mReactNativeHost)

    override val reactNativeHost: ReactNativeHost
        get() = mReactNativeHost

}
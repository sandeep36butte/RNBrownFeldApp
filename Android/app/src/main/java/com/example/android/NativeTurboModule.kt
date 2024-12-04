package com.example.android

import android.os.Build
import com.facebook.react.bridge.ReactApplicationContext
import com.example.android.NativeTurboModuleSpec
import com.facebook.react.bridge.Promise

class NativeTurboModule(reactContext: ReactApplicationContext):NativeTurboModuleSpec(reactContext) {
    override fun getName() = NAME

    override fun getDeviceModel(promise: Promise) {
        val manufacturer: String = Build.MANUFACTURER
        val model: String = Build.MODEL
        promise.resolve(manufacturer + model)
    }
    companion object {
        const val NAME = "NativeTurboModule"
    }
}
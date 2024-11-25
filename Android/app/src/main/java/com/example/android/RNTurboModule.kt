package com.example.android

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import com.facebook.react.bridge.ReactApplicationContext
import com.example.android.RNTurboModuleSpec
import com.facebook.react.bridge.Promise

class RNTurboModule(reactContext: ReactApplicationContext): RNTurboModuleSpec(reactContext) {
    override fun getName() = NAME

    override fun getDeviceModel(promise: Promise) {
        val manufacturer: String = Build.MANUFACTURER
        val model: String = Build.MODEL
        promise.resolve(manufacturer + model)
    }
    companion object {
        const val NAME = "RNTurboModule"
    }
}
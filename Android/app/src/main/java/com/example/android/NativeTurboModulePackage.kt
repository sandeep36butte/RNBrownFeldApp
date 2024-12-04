package com.example.android


import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class NativeTurboModulePackage:TurboReactPackage() {

    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? =
        if (name == NativeTurboModule.NAME) {
            NativeTurboModule(reactContext)
        } else {
            null
        }

    override fun getReactModuleInfoProvider() = ReactModuleInfoProvider {
        mapOf(
            NativeTurboModule.NAME to ReactModuleInfo(
                _name = NativeTurboModule.NAME,
                _className = NativeTurboModule.NAME,
                _canOverrideExistingModule = false,
                _needsEagerInit = false,
                isCxxModule = false,
                isTurboModule = true
            )
        )
    }
}
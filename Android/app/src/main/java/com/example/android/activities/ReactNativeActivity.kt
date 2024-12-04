package com.example.android.activities

import android.os.Bundle
import android.util.Log
import com.facebook.react.ReactActivity
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint
import com.facebook.react.defaults.DefaultReactActivityDelegate

class ReactNativeActivity : ReactActivity() {

    class RNTesterActivityDelegate(val activity: ReactActivity, mainComponentName: String) :
        DefaultReactActivityDelegate(activity, mainComponentName,
            DefaultNewArchitectureEntryPoint.fabricEnabled
        ) {
        private lateinit var initialProps: Bundle
        override fun onCreate(savedInstanceState: Bundle?) {
            Log.d("ReactNative", "ReactDelegate")
            val payload = activity.intent?.getStringExtra("payload")
            initialProps = Bundle().apply {
                putString("initialProps", "props123")
                putString("payload", payload)
                putString("appName", "ReactNativeBrownFieldApp")

            }
            super.onCreate(savedInstanceState)
        }

        override fun getLaunchOptions():Bundle {
            Log.d("ReactNative", "calling LaunchActions")
            if(this::initialProps.isInitialized){
                return initialProps
            }else{
                return Bundle()
            }
        }
    }

    override fun createReactActivityDelegate() = RNTesterActivityDelegate(this, mainComponentName)

    override fun getMainComponentName() = "ReactNativeBrownFieldApp"
}

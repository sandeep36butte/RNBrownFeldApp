import React, {useEffect, useState} from "react";
import { View, Text, StyleSheet, NativeModules } from "react-native";
import NativeTurboModule from "../specs/NativeTurboModule";

export default function App(){
    const isNewArchitectureEnabled = global.__turboModuleProxy != null;
    console.log('Is New Architecture Enabled:', isNewArchitectureEnabled);
    console.log(`nativemodules: ${JSON.stringify(NativeModules)}`);
    useEffect(() => {
        NativeTurboModule.getDeviceModel()
            .then(deviceDetails => {
                console.log(`devices:${deviceDetails}`);
            })
    }, [])
    return(
        <View>
            <Text style={{fontSize:30}}>
                Rn New Architecture in BrownField Apps loading bundle from custom location.
            </Text>
        </View>
    )
   
}
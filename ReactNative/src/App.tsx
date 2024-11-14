import React, {useEffect, useState} from "react";
import { View, Text, StyleSheet, NativeModules } from "react-native";
import {Camera, useCameraDevice} from "react-native-vision-camera";

export default function App(){
    const isNewArchitectureEnabled = global.__turboModuleProxy != null;
    console.log('Is New Architecture Enabled:', isNewArchitectureEnabled);
    console.log(`nativemodules: ${JSON.stringify(NativeModules)}`);
    const [cameraStatus, setCameraStatus] = useState<any>();
    const device = useCameraDevice('back');
    // const device = null;
    console.log("device", device);
    useEffect(() => {
        const status = Camera.getCameraPermissionStatus();
        setCameraStatus(status);
      }, []);
    
      useEffect(() => {
        if (!cameraStatus || cameraStatus === 'granted') {
          return;
        }
    
        Camera.requestCameraPermission().then(setCameraStatus);
      }, [cameraStatus]);
   if(!device){
    return(
        <View>
            <Text style={{fontSize:30}}>
                Rn New Architecture in BrownField Apps. No Camera Device found
            </Text>
        </View>
    )
   }
   else{
    return(
        <View>
            <Text style={{fontSize:30}}>
                Rn New Architecture in BrownField Apps
            </Text>
            <Camera
                style={StyleSheet.absoluteFill}
                device={device}
                isActive={true}
            />
        </View>
    )
   }
}
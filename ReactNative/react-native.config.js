/** @type import("@react-native-community/cli-types").Config */

module.exports = {
    project: {
      android: {
        sourceDir: '../Android', 
        packageName: 'com.example.android'
      },
    },
    assets:["../Android/android/app/src/main/assets/*", "./assets/fonts/*"],
  };

  /**
   * npx react-native bundle --platform android --dev false --entry-file index.js --bundle-output ../Android/app/src/main/assets/index.android.bundle --assets-dest ../Android/app/src/main/res/
   */
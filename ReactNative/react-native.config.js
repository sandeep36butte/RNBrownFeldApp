/** @type import("@react-native-community/cli-types").Config */

module.exports = {
    project: {
      android: {
        sourceDir: '../Android', 
        packageName: 'com.example.android'
      },
    },
    assets:["../Android/app/src/main/assets/*", "./assets/fonts/*"],
  };
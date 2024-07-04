// /* eslint-disable @typescript-eslint/no-var-requires */
// const path = require('path')
// const { getDefaultConfig, mergeConfig } = require('@react-native/metro-config')

// const defaultConfig = getDefaultConfig(__dirname)
// const { resolver: { sourceExts, assetExts } } = defaultConfig

// /**
//  * Metro configuration
//  * https://facebook.github.io/metro/docs/configuration
//  *
//  * @type {import('metro-config').MetroConfig}
//  */
// const config = {
//   transformer: {
//     babelTransformerPath: require.resolve('react-native-svg-transformer')
//   },
//   resolver: {
//     assetExts: assetExts.filter((ext) => ext !== 'svg'),
//     sourceExts: [...sourceExts, 'svg']
//   },
//   watchFolders: [path.resolve(__dirname, '../')]
// }
// module.exports = mergeConfig(defaultConfig, config)

const {getDefaultConfig, mergeConfig} = require('@react-native/metro-config');

/**
 * Metro configuration
 * https://facebook.github.io/metro/docs/configuration
 *
 * @type {import('metro-config').MetroConfig}
 */
const config = {};

module.exports = mergeConfig(getDefaultConfig(__dirname), config);
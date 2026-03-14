module.exports = function (api) {
  api.cache(true);
  return {
    presets: ["babel-preset-expo"],
    plugins: [
      // Required for react-native-reanimated's worklet transform
      "react-native-reanimated/plugin",
    ],
  };
};

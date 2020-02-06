const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

const htmlWebpackPlugin = new HtmlWebpackPlugin({
  template: path.join(__dirname, "./src/index.html"),
  filename: "index.html"
});

module.exports = {
  mode: "development",
  plugins: [htmlWebpackPlugin],
  module: {
    // 所有第三方 模块的配置规则
    rules: [
      // 第三方匹配规则
      { test: /\.js|jsx$/, use: "babel-loader", exclude: /node_modules/ } // 千万别忘记添加 exclude 排除项
    ]
  }
};

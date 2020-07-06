let path = require('path');
let webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin')


// console.log("----"+path.dirname())


module.exports = {
    mode:'development',
    entry: ['./src/c1.ts','./src/c2.ts'],
    output: {
        path: path.join(__dirname, 'dist'), //输出目录的配置，模板、样式、脚本、图片等资源的路径配置都相对于它
        filename: '[name]_bundle_[hash].js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                use: ['babel-loader']
            }
        ]
    },
    devtool:"source-map",
    plugins: [
        new HtmlWebpackPlugin({
        template: './index.html',
        filename: "[name].html",
        minify: {
            removeComments: true,
            collapseWhitespace: true,
            removeAttributeQuotes: true
      },
    }),
    ]
};
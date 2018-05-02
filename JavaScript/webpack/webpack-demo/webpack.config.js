const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');


module.exports = {
	// entry : './src/index.js',
	
 	// devtool: 'inline-source-map',
	entry: {
		app:'./src/index.js',
		print: './src/print.js'
	},
	devServer :{
		contentBase : './dist'
	},
	plugins: [
     new HtmlWebpackPlugin({
       title: 'customer title'
     })
    ],
	output: {
		filename : '[name].bundle.js',
		path: path.resolve(__dirname , 'dist')
	},
	module: {
		rules :[
			{
				test: /\.css$/,
				use: [
					'style-loader',
					'css-loader'
				]

			},
		    {
         		test: /\.(png|svg|jpg|gif)$/,
         		use: [
           		'file-loader'
         		]
         	}	
		]
	}
};

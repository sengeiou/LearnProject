var gulp = require('gulp');
var postcss = require('gulp-postcss');
var autoprefixer = require('autoprefixer');
var cssnext = require('cssnext');
var precss  = require('precss');
var vars = require('postcss-simple-vars');
var cssnano = require('cssnano');
var rename = require('gulp-rename');


gulp.task('css',function(){
	var processors = [
		autoprefixer,
		cssnext,
		precss,
		vars,
		cssnano,
		rename
	];

	return gulp.src('./src/*.css')
	.pipe(postcss(processors))
	.pipe(rename('style.min.css'))
	.pipe(gulp.dest('./dest'))
});



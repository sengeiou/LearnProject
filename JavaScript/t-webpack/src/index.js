import './style.css'
import Icon from './timg.jpg'
import print from './print.js';
import Vue from 'Vue'


var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
});


function component() {
  var element = document.createElement('div');

  // Lodash（目前通过一个 script 脚本引入）对于执行这一行是必需的
//  element.innerHTML = lodash.join(['Hello', 'webpack'], ' ');
//  element.classList.add('hello');
  //

  var myIcon = new Image();
  myIcon.src= Icon;
  element.appendChild(myIcon);	

  var btn = document.createElement('button');
  btn.innerHTML= "t123nt";
  btn.onclick= print;

  element.appendChild(btn);
	
  return element;
}

document.body.appendChild(component());

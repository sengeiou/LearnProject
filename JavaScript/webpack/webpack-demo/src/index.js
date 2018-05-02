import _ from 'lodash';
import './style.css';
import icon from './test.jpg'
import printMe from './print.js'

function component() {
  var element = document.createElement('div');

  // Lodash（目前通过一个 script 脚本引入）对于执行这一行是必需的
  element.innerHTML = _.join(['Hello', 'webpack'], ' ');
  element.classList.add('hello');

  var img = new Image();
  img.src = icon;
  console.log(img);

  element.appendChild(img);

  // appen btn and print logs 
  var btn = document.createElement('button');
  btn.innerHTML = 'clicl me and chekc the console';
  btn.onclick = printMe;
  element.appendChild(btn);

  return element;
}

document.body.appendChild(component());

import React from 'react';
import logo from './logo.svg';
import './App.css';

function Hello(props){
return <h1>Hello---{props.item.name}</h1>
}

const dog ={
  name:"cocoa",
  age:31
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Hello item={dog}></Hello>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;

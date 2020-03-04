import React from 'react';
import logo from './logo.svg';
import './App.css';

function getName(){
  return 'cocoa'
}

function isTrue(){
  return true
}


class Text extends React.Component{
  constructor(props){
    super(props)
    this.state = {date : new Date()}
  }

  updateTime(){
    this.setState({
      date: new Date()
    }) 
  }


  componentDidMount(){
    this.timerId = setInterval(()=>{
        this.updateTime()
    },1000)
  }

  componentWillUnmount(){
     clearInterval(this.timerId)
  }



  render(){
    return <h1>this is customer text {this.state.date.toLocaleTimeString()}</h1>
  }
}


function App() {
  return (
    <div className="App">
      <header className="App-header">
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
          {getName()}
        </a>
        <Text ></Text>
      </header>
    </div>
  );
}

export default App;

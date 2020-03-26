import React from 'react';
import logo from './logo.svg';
import './App.css';
import ListComponent from './List.js'



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

  handleClick(e){
    alert("component has been clicked! and this = "+this.state.date  + "   and e="+e)
  }


  render(){
    if(this.props.isLogin){
      return <h1 onClick={(e) => this.handleClick(e)}>this is customer text {this.state.date.toLocaleTimeString()}</h1>
    }else{
      return <div>no login</div>
    }

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
        <Text isLogin={true}></Text>
        <Text isLogin={false}></Text>

        <ListComponent></ListComponent>

      </header>
    </div>
  );
}

export default App;

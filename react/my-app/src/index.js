import React from "react";
import ReactDOM from "react-dom";

import './index.css'

const app = <h1>123123</h1>;

const creatApp = () => {
  return (
    <div id="app">
      <h1 >this is h1</h1>
    </div>
  );
};

class App extends React.Component {
  render() {
    const style = { color: "red" };
    return (<div>
        <h1 style={style}>red text</h1>
        <h2 className="green-text">12312312</h2>
    </div>)
  }
}

ReactDOM.render(<App name="cocoa" />, document.querySelector("#root"));

import React, { Component } from "react";
import logo from "src/pages/react-multi.png";

function Test(props) {
  return <h1>Hello world {props.name}</h1>;
}

function ListView() {
  const numbers = [1, 2, 3, 4, 5];
  const listItems = numbers.map((number) => <li key={number}>{number * number}</li>);
  return listItems;
}

export default class Nav extends Component {
  render() {
    return (
      <div className="menu columns">
          <img src={logo} />
          <div>Learn React</div>
      </div>
    );
  }
}

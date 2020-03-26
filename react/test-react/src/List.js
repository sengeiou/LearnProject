import React from "react";

let numbers = [1, 2, 3, 4, 5];

class ListComponent extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    const numList = numbers.map((num ,index) => <li key={index} >{num * num}</li>);
    console.log(numList)
    return (
      <div>
        <div>--------------this is list component-------------</div>
        <ul>{numList}</ul>
      </div>
    );
  }
}

export default ListComponent;

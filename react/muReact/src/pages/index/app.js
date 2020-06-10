/********************************
 * @file: home page
 * @desc: overview react multi page app
 * @author: leinov
 * @date:2018-12-06
 *******************************/

import React, { Component } from "react";
import Nav from "component/nav";
import Footer from "component/footer"


class Clock extends Component{

	constructor(props){
		super(props);
		this.state = {date: new Date(), temp : true};
		// this.handleClick = this.handleClick.bind(this)
	}	

	componentDidMount(){
		if(!this.state.temp){
			return 
		}
		this.timerId = setInterval(
			()=>{
				this.tick()
			},
			1000
		)
	}

	componentWillUnmount(){
		clearInterval(this.timerId)
	}

	tick(){
		this.setState({
			date: new Date()
		})
	}
	// handleClick(){
	// 	let temp = this.state.temp
	// 	if(temp){
	// 		clearInterval(this.timerId)
	// 	}else{
	// 		this.timerId = setInterval(
	// 			()=>{
	// 				this.tick()
	// 			},
	// 			1000
	// 		)
	// 	}	
	// 	this.setState({
	// 		temp: !temp
	// 	})
	// }

	handleClick = () => {
		console.log(this)
		alert("123")
	}


	render(){
		return (
			<div>
				<button onClick={this.handleClick}>{this.state.temp?'开始':'暂停'}</button>
				<h2>{this.state.date.toLocaleTimeString()}</h2>
			</div>
		)
	}

}

export default class App extends Component {
	render() {
		return (
			<div>
				<Nav />
				<div className="main index column is-8">
					 <Clock />
				</div>
				<Footer />
			</div>
			
		);
	}
}

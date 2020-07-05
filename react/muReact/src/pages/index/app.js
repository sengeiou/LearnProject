/********************************
 * @file: home page
 * @desc: overview react multi page app
 * @author: leinov
 * @date:2018-12-06
 *******************************/

import React, { Component } from "react";
import Nav from "component/nav";
import Footer from "component/footer"

class ListView extends Component{
	render(){
		return  <div class="test">1123123</div>
	}
}

export default class App extends Component {
	render() {
		return (
			<div>
				<Nav />
				<div className="main index column is-8">
					
				<ListView></ListView>

				</div>
				<Footer />
			</div>
			
		);
	}
}

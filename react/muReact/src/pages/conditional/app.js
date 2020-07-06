/********************************
 * @file: todolist page
 * @desc: react-redux todo list
 * @author: leinov
 * @date:2018-12-06
 *******************************/

import React ,{Component} from "react";
import Footer from "component/footer"
import Nav from "component/nav";


class LoginView extends Component{

	render(props){
		return (
			<button onClick={props.onClick}>Login in</button>
		)
	}
}


class LogoutView extends Component{

	render(props){
		return (
		<button onClick={props.onClick}>Logout {props.state.name}</button>
		)
	}
}


class App extends React.Component {
	constructor(props){
		super(props);
		this.state={}
	}

	render() {
		return (
			<div>
				<div className="main todo column is-8">
					<h1 className="title"> todo list</h1>
				</div>
				<Footer />
			</div>
		);
	}
}


export default App

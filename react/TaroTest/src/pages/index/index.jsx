import Taro, { Component } from '@tarojs/taro'
import { View, Text,Button } from '@tarojs/components'
import './index.scss'
import Welcome from './com'


export default class Index extends Component {

  constructor (props) {
    super(props)
    this.state = {
        isToggleOn: true,
        date: new Date()
    }
  }

  componentWillMount () {
      
  }

  componentDidMount () {
      this.start()
  }

  componentWillUnmount () { 
      clearTimeout(this.timer)
  }

  componentDidShow () { }

  componentDidHide () { }

  config = {
    navigationBarTitleText: '首页'
  }

  start(){
    this.timer = setTimeout(()=>{
      this.tick()
    },1000)
  }

  tick () {
    this.setState({
      date: new Date()
    });
    this.start()
  }

  onClick = (e) => {
    e.stopPropagation()
    this.setState(prevState => ({
      isToggleOn: !prevState.isToggleOn
    }))
  }


  render () {
    return (
      <View className='index'>
        <Text>Hello world!</Text>
        <Button  onClick={this.onClick}>{this.state.isToggleOn ? 'on' : 'off'}</Button>
        <Welcome name="Wallace" />
        <Text>{this.state.date.toLocaleTimeString()}</Text>
      </View>
    )
  }
}

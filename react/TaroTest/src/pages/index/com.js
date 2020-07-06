
import Taro, { Component } from '@tarojs/taro'


export default class Welcome extends Component {
    render () {
    return <View><Text>Hello{this.props.name}</Text></View>
    }
}
  
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:shared_preferences/shared_preferences.dart';

class TestWillPopScope extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
          title: Text("this is title"),
          actions: [FlatButton(onPressed: () {}, child: Text("add"))]),
      body: Content1(),
    );
  }
}

class ShareDataWidget extends InheritedWidget {
  final int data;

  ShareDataWidget({@required this.data, Widget child}): super(child: child);

  static ShareDataWidget of(BuildContext context) {
    return context.dependOnInheritedWidgetOfExactType<ShareDataWidget>();
  }

  @override
  bool updateShouldNotify(ShareDataWidget oldWidget) {
    // TODO: implement updateShouldNotify
    return false;
  }


}

class Content1 extends StatefulWidget {
  @override
  _ContentState createState() => _ContentState();
}

class _ContentState extends State<Content1> {
  int count = 0;

  @override
  Widget build(BuildContext context) {
    return Center(
      child: ShareDataWidget(
          data: count,
          child: Column(
            children: [
              Padding(
                padding: const EdgeInsets.only(bottom: 20.0),
                child: _TestWidget(),//子widget中依赖ShareDataWidget
              ),
              FlatButton(
                child: Text("123"),
                onPressed: () {
                  setState(() {
                    ++count;
                  });
                },
              )
            ],
          )),
    );
  }
}

class _TestWidget extends StatefulWidget {
  @override
  __TestWidgetState createState() => new __TestWidgetState();
}

class __TestWidgetState extends State<_TestWidget> {
  @override
  Widget build(BuildContext context) {
    //使用InheritedWidget中的共享数据
    print("__TestWidgetState rebuild");
    var msg = ShareDataWidget.of(context).data.toString();
    return Text("$msg--");
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    //父或祖先widget中的InheritedWidget改变(updateShouldNotify返回true)时会被调用。
    //如果build中没有依赖InheritedWidget，则此回调不会被调用。
    print("Dependencies change");
  }
}

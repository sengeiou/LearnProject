import 'package:flutter/material.dart';

class NewRouter extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
        title: Text("this is title"),
      ),
      body: Center(child: CounterWidget()),
    );
  }
}

class CounterWidget extends StatefulWidget {
  const CounterWidget({Key key, this.ininCounter = 0});

  final int ininCounter;

  @override
  _CounterWidgetState createState() {
    return _CounterWidgetState();
  }
}

class _CounterWidgetState extends State<CounterWidget> {
  int initCounter = 0;

  void pressed() {
    setState(() {
      this.initCounter += 1;
    });
  }

  void closeAndSend() {
    var gifts = {
      // Key:    Value
      'name': 'cocoa',
      'age': '11'
    };

    Navigator.pop(context, gifts);
    // Navigator.
  }


  @override
  void initState() {
    super.initState();
    initCounter = widget.ininCounter;
  }

  @override
  Widget build(BuildContext context) {
    return Center(
        child: Padding(
            padding: EdgeInsets.all(10.0),
            child: Column(
      verticalDirection: VerticalDirection.up,
      children: [
        Image(
            image: NetworkImage(
                "https://avatars2.githubusercontent.com/u/20411648?s=460&v=4"),
            width: 100,
            height: 100,
            fit: BoxFit.contain),
        Text(
          "Welcome to the Swift community. Together we are working to build a programming language to empower everyone to turn their ideas into apps on any platform. Test",
          textAlign: TextAlign.center,
          maxLines: 1,
          style: TextStyle(color: Colors.red),
        ),
        FlatButton(
          onPressed: closeAndSend,
          child: Text("close and send name"),
        ),
        FlatButton(
          onPressed: pressed,
          child: Text("plus"),
        ),
        Text("${initCounter}")
      ],
    )));
  }
}

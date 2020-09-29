import 'package:flutter/material.dart';

class TestContainer extends StatelessWidget {
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
    return SingleChildScrollView(
        child: Column(
      children: [
        Padding(
          padding: EdgeInsets.symmetric(vertical: 12),
          child: Text("EdgeInsets.symmetric(vertical: 12)"),
        ),
        Padding(
          padding: EdgeInsets.all(12),
          child: Text("EdgeInsets.all(12)"),
        ),
        ConstrainedBox(
            constraints: BoxConstraints(minWidth: double.infinity),
            child: Container(
              decoration: new BoxDecoration(
                color: Colors.grey,
              ),
              child: Text(
                "1123123123",
                textAlign: TextAlign.left,
                style: TextStyle(),
              ),
            )),
        SizedBox(
          width: 90,
          height: 90,
          child: Container(
            color: Colors.green,
            child: Text(
              "123",
              style: TextStyle(),
            ),
          ),
        )
      ],
    ));
  }
}

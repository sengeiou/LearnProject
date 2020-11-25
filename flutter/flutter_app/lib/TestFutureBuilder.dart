import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:shared_preferences/shared_preferences.dart'

class TestFutureBuilder extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
          title: Text("this is title"),
          actions: [FlatButton(onPressed: () {}, child: Text("add"))]),
      body: Content(),
    );
  }
}

class Content extends StatefulWidget {
  @override
  _ContentState createState() => _ContentState();
}

Future<String> mockRemote() {
  return Future.delayed(
      Duration(seconds: 3), () => "this info from remote server!!");
}

Stream<num> mockStreamRemote() {
  return Stream.periodic(Duration(seconds: 1), (i) => i);
}

class _ContentState extends State<Content> {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Text("FutureBuilder"),
        FutureBuilder(
            future: mockRemote(),
            builder: (BuildContext context, AsyncSnapshot<String> snapshot) {
              if (snapshot.connectionState == ConnectionState.done) {
                return Center(
                  child: Text("${snapshot.data}----"),
                );
              } else if (snapshot.connectionState == ConnectionState.waiting) {
                return Center(
                  child: Text("waiting"),
                );
              } else {
                return Center(
                  child: Text("loading"),
                );
              }
            }),
        Padding(
          padding: EdgeInsets.only(top: 100),
          child: Column(
            children: [
              Text("StreamBuilder"),
              StreamBuilder(
                  stream: mockStreamRemote(),
                  builder: (BuildContext context, AsyncSnapshot snapshot) {
                    return Text("mockStreamRemote--${snapshot.data}");
                  })
            ],
          ),
        )
      ],
    );
  }
}

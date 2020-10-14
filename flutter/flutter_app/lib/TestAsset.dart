import 'package:flutter/material.dart';

class TestAsset extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
        title: Text("this is title"),
      ),
      body: Content(),
    );
  }
}

class Content extends StatefulWidget {
  @override
  _ContentState createState() => _ContentState();
}

class _ContentState extends State<Content> {
  String localJSONString = "";

  void getJsonAsset(BuildContext context) {
    DefaultAssetBundle.of(context)
        .loadString("files/test1.json")
        .then((value) => setState(() {
              localJSONString = value;
            }));
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        FlatButton(
            onPressed: () {
              getJsonAsset(context);
            },
            child: Text("load local json")),
        Text("${localJSONString}"),
        Image.asset(
          "images/test.jpg",
          width: 100,
          height: 100,
        ),
        Image.asset(
          "images/dribbble4.png",
          width: 100,
          height: 100,
        )
      ],
    );
  }
}

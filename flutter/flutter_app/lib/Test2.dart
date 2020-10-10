import 'package:flutter/material.dart';


class Test2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
        title: Text("this is title"),
      ),
      body: Center(child: ContentWidget()),
    );
  }
}



class ContentWidget extends StatefulWidget {
  @override
  _Test2State createState() => _Test2State();


}

class _Test2State extends State<ContentWidget> {
  @override
  Widget build(BuildContext context) {
    return Container();
  }
}

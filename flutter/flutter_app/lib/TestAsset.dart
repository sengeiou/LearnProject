import 'package:flutter/material.dart';
import './util.dart';

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

  void test(){
    precacheImage(NetworkImage(""), context);
  }


  void getJsonAsset() {
    DefaultAssetBundle.of(context)
        .loadString("files/test1.json")
        .then((value) => setState(() {
              localJSONString = value;
            }));
  }



  ListView buildList({num size = 100}) {
    return ListView.builder(
      itemCount: imgList.length,
      itemBuilder: (BuildContext context, int index) {
        //
        return ListTile(
            title: Column(
          children: [
            Text("${index}"),
            Image.network(imgList[index],
                width: 300, height: 300, fit: BoxFit.cover)
          ],
        ));
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return buildList();
    // return Column(
    //   children: [
    //     FlatButton(
    //         onPressed: () {
    //           showDialog(
    //               context: context,
    //               builder: (BuildContext context) {
    //                 return AlertDialog(
    //                   title: new Text('标题'),
    //                   content: new SingleChildScrollView(
    //                     child: new ListBody(
    //                       children: <Widget>[
    //                         new Text('内容 1'),
    //                         new Text('内容 2'),
    //                       ],
    //                     ),
    //                   ),
    //                   actions: <Widget>[
    //                     new FlatButton(
    //                       child: new Text('确定'),
    //                       onPressed: () {
    //                         Navigator.of(context).pop();
    //                       },
    //                     ),
    //                     new FlatButton(
    //                       child: new Text('quxiao'),
    //                       onPressed: () {
    //                         Navigator.of(context).pop();
    //                       },
    //                     ),
    //                   ],
    //                 );
    //               });
    //         },
    //         child: Text("show dialog")),
    //     FlatButton(
    //         onPressed: () {
    //           getJsonAsset(context);
    //         },
    //         child: Text("load local json")),
    //     Text("${localJSONString}"),
    //     Image.asset(
    //       "images/test.jpg",
    //       width: 100,
    //       height: 100,
    //     ),
    //     Image.asset(
    //       "images/dribbble4.png",
    //       width: 100,
    //       height: 100,
    //     ),
    //     // FadeInImage()
    //     // buildList()
    //   ],
    // );
  }
}

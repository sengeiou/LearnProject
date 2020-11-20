// import 'dart:html';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'MediaUI.dart';
import 'TestAsset.dart';
import 'TestContainer.dart';
import 'TestEvent.dart';
import 'TestLocalCache.dart';
import 'TestWillPopScope.dart';
import 'TestFutureBuilder.dart';

// mock data  https://github.com/postbird/FlutterHelloWorld/blob/master/demo1/lib/mock/list.dart


void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class Item {
  String title;
  Widget router;

  Item(String title, Widget router) {
    this.title = title;
    this.router = router;
  }
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  String msg = "";

  void setMsg(msg) {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      this.msg = msg;
    });
  }

  void getHttp() async {
    try {
      Response response = await Dio().get("http://httpbin.org/get");
      print(response);
      setMsg(response.toString());
    } catch (e) {
      print(e);
    }
  }

  List<Item> dataList = [
    Item("Container", TestContainer()),
    Item("MediaUI", MediaUI()),
    Item("TestEvent", TestEvent()),
    Item("TestAsset", TestAsset()),
    Item("TestLocalCache", TestLocalCache()),
    Item("TestWillPopScope", TestWillPopScope()),
    Item("FutureBuilder、StreamBuilder", TestFutureBuilder())
  ];

  List<Widget> getList() {
    var list = List<Widget>();
    for (var i = 0; i < dataList.length; i++) {
      var iItem = dataList[i];

      list.add(InkWell(
          onTap: () {
            Navigator.push(context, MaterialPageRoute(builder: (context) {
              return iItem.router;
            })).then((value) => print("----${value}"));
          },
          child: Padding(
              padding: EdgeInsets.fromLTRB(10, 10, 10, 10),
              child: ClipRRect(
                  borderRadius: BorderRadius.circular(10),
                  child: Container(
                    decoration: BoxDecoration(color: Colors.grey),
                    padding: EdgeInsets.symmetric(vertical: 15, horizontal: 15),
                    child: Row(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        ClipRRect(
                          child: Image(
                              fit: BoxFit.fill,
                              image: NetworkImage(
                                  "https://s5.mogucdn.com/mlcdn/c45406/200929_292ce18g9750j4dhcb5cj955h5alk_1080x1670.jpg_600x999.v1c96.81.webp"),
                              width: 50,
                              height: 50),
                          borderRadius: BorderRadius.circular(50),
                        ),
                        Expanded(
                            flex: 1,
                            child: Padding(
                                padding: EdgeInsets.fromLTRB(30, 0, 0, 0),
                                child: Text(iItem.title))),
                        Padding(
                          padding: EdgeInsets.fromLTRB(10, 0, 0, 0),
                          child: Text(
                            "this is item ${i}",
                            style: TextStyle(
                                color: Colors.black45,
                                fontSize: 20,
                                backgroundColor: Colors.blue),
                          ),
                        )
                      ],
                    ),
                  )))));
    }
    return list;
  }

  Future<bool> refresh() async {
    try {
      Response response = await Dio().get("http://httpbin.org/get");
      print(response);
    } catch (e) {
      print(e);
    }
    return true;
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
          // Center is a layout widget. It takes a single child and positions it
          // in the middle of the parent.
          child: RefreshIndicator(
              child: ListView(
                children: getList(),
              ),
              onRefresh: refresh)

          // Column(
          //   // Column is also a layout widget. It takes a list of children and
          //   // arranges them vertically. By default, it sizes itself to fit its
          //   // children horizontally, and tries to be as tall as its parent.
          //   //
          //   // Invoke "debug painting" (press "p" in the console, choose the
          //   // "Toggle Debug Paint" action from the Flutter Inspector in Android
          //   // Studio, or the "Toggle Debug Paint" command in Visual Studio Code)
          //   // to see the wireframe for each widget.
          //   //
          //   // Column has various properties to control how it sizes itself and
          //   // how it positions its children. Here we use mainAxisAlignment to
          //   // center the children vertically; the main axis here is the vertical
          //   // axis because Columns are vertical (the cross axis would be
          //   // horizontal).
          //   mainAxisAlignment: MainAxisAlignment.center,
          //   children: <Widget>[
          //     Text(
          //       '${msg}',
          //     ),
          //     Text(
          //       '$_counter',
          //       style: Theme.of(context).textTheme.headline4,
          //     ),
          //     FlatButton(onPressed: getHttp,  child: Text("getHttp")),
          //     FlatButton(onPressed: (){
          //       Navigator.push(context, MaterialPageRoute(builder: (context){
          //           return NewRouter();
          //       })).then((value) => print("----${value}"));
          //     }, child: Text("test1")),
          //
          //
          //
          //   ],
          // ),
          ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}

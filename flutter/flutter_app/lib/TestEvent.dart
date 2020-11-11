import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:shared_preferences/shared_preferences.dart';

class TestEvent extends StatelessWidget {
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

class _ContentState extends State<Content> {
  PointerEvent _event;
  double _top = 0.0;
  double _left = 0.0;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _toast();
  }

  void _toast({msg = "131"}) {
    Fluttertoast.showToast(
        msg: msg,
        toastLength: Toast.LENGTH_SHORT,
        gravity: ToastGravity.BOTTOM,
        timeInSecForIosWeb: 1,
        backgroundColor: Colors.red,
        textColor: Colors.white,
        fontSize: 16.0);
  }

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        Container(
          width: 500,
          height: 500,
          child: Positioned(
            top: _top,
            left: _left,
            child: GestureDetector(
              child: Text("123123123${_left}"),
              onPanUpdate: (DragUpdateDetails details) {


                // DefaultAssetBundle.of(context).loadString("files/test1.json").then((value) =>
                //     print("---DefaultAssetBundle---${value}")
                // );


                print("onpanupdte ${details.delta.dx}");
                setState(() {
                  _left += details.delta.dx;
                  _top += details.delta.dy;
                });
              },
              onPanDown: (DragDownDetails e) {
//打印⼿指按下的位置(相对于屏幕)
                print("⽤户⼿指按下： ${e.globalPosition}");
              },
              onPanEnd: (DragEndDetails e){
//打印滑动结束时在x、 y轴上的速度
                print(e.velocity);
              },
            ),
          ),
        ),
        Container(
          child: Listener(
            child: Container(
              color: Colors.green,
              child: Container(
                child: SizedBox(
                  child: Text(_event?.toString() ?? "123"),
                  height: 30,
                  width: 30,
                ),
              ),
            ),
            onPointerDown: (PointerDownEvent event) {
              setState(() {
                this._event = event;
              });
            },
            onPointerMove: (PointerMoveEvent event) {
              setState(() {
                this._event = event;
              });
            },
            onPointerUp: (PointerUpEvent event) {
              _toast();
              setState(() {
                this._event = event;
              });
            },
          ),
        ),
        GestureDetector(
          child: Container(
            color: Colors.red,
            child: SizedBox(
              child: Text("GestureDetector"),
              height: 30,
              width: 30,
            ),
          ),
          onTap: () {
            _toast(msg: "this is toast");
          },
        )
      ],
    );
  }
}

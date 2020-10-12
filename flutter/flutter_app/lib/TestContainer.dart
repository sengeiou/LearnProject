import 'package:flutter/material.dart';

class TestContainer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
        title: Text("this is title"), 
          actions:[
                  FlatButton(onPressed: (){}, child: Text("add"))  
          ]
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
  List<String> _list = [
    '盗墓笔记',
    '鬼吹灯',
    '这个书名是凑的',
    '藏海花',
    '这个书名是凑的',
    '藏海花',
    '沙海',
    '藏海花',
    '这个书名是凑的',
    '藏海花'
  ];


  List<Widget> getWrapBtn(){
    return _list.map((e) => FlatButton(onPressed: (){}, child: Text(e,
      style: TextStyle(
            backgroundColor: Colors.green
      ),
    ))).toList();

  }




  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
        child: Column(
      children: [
        Row(
          children: [Text("测试 row 中直接嵌套text ，过长会报错")],
        ),
        Padding(
            padding: EdgeInsets.all(20),
            child: Text("****下面的例子使用Expanded，进行控件等分")),
        Row(
          textBaseline: TextBaseline.ideographic,
          children: [
            Expanded(
              child: Container(
                color: Colors.red,
                child: Text(
                  "1123",
                  textAlign: TextAlign.center,
                  style: TextStyle(fontSize: 42),
                ),
              ),
            ),
            Expanded(
              child: Text(
                "123123123123123123123123123123",
                textAlign: TextAlign.center,
                style: TextStyle(fontSize: 22),
              ),
            )
          ],
        ),
        Row(
          textDirection: TextDirection.ltr,
          mainAxisSize: MainAxisSize.max,
          children: [
            Text(
              "TextAlign",
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 42),
            ),
            Text(
              "TextAlignTextAlignTextA",
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 12, color: Colors.red),
            ),
          ],
        ),
        Padding(
            padding: EdgeInsets.all(20),
            child: Text(
                "****上面的row 布局中，如果text的内容过长，则会出错,使用下面的wrap 和 flow 则可以解决问题")),
        Wrap(
          children: [
            Text(
              "这段文字在wrap 中 这段文字在wrap 中这段文字在wrap 中这段文字在wrap 中这段文字在wrap 中这段文字在wrap 中这段文字在wrap 中这段文字在wrap 中。",
              style: TextStyle(fontSize: 12, color: Colors.red),
            )
          ],
        ),
        Padding(
            padding: EdgeInsets.all(20),
            child: Text("****wrap 的另一个作用，当剩余的空间放不下子组件时，会自动换行")),
        Wrap(
          children: getWrapBtn(),
        ),
        Padding(padding: EdgeInsets.all(20), child: Text("****下面介绍层叠布局")),
        Container(
          color: Colors.amberAccent,
          child: Stack(
            children: [
              Text(
                "this is xxxxxx 1",
                style: TextStyle(fontSize: 12, color: Colors.red),
              ),
              Text(
                "this is yyyyyy 2",
                style: TextStyle(fontSize: 14, color: Colors.green),
              )
            ],
          ),
        ),
        Padding(
          padding: EdgeInsets.symmetric(vertical: 12),
          child: Text("测试padding EdgeInsets.symmetric(vertical: 12)"),
        ),
        Padding(
          padding: EdgeInsets.all(12),
          child: Text("测试padding EdgeInsets.all(12)"),
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
        ),
      ],
    ));
  }
}

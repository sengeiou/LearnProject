import 'package:flutter/material.dart';

import 'TestAsset.dart';

class TestContainer extends StatefulWidget {
  @override
  _ScaffoldRouteState createState() => _ScaffoldRouteState();
}

class _ScaffoldRouteState extends State<TestContainer> {
  int currentIndex = 0;
  var counterWidget = CounterWidget();

  @override
  Widget build(BuildContext context) {
    // TODO: implement Content
    // throw UnimplementedError();
    return Scaffold(
      drawer: Drawer(
        child: Padding(
          padding: EdgeInsets.only(top: MediaQuery.of(context).padding.top),
          child: Text(
              "${Theme.of(context).platform} ${MediaQuery.of(context).padding.top}"),
        ),
      ), //抽屉
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(icon: Text("1"), label: "tab1"),
          BottomNavigationBarItem(icon: Text("2"), label: "tab2"),
          BottomNavigationBarItem(icon: Text("3"), label: "tab3"),
        ],
        currentIndex: currentIndex,
        onTap: (int value) {
          setState(() {
            currentIndex = value;
          });
        },
      ),
      appBar: AppBar(
          title: Text("this is title"),
          actions: [FlatButton(onPressed: () {}, child: Text("add"))]),
      body: Center(child: currentIndex == 0 ? counterWidget : Content()),
    );
  }
}

class CounterWidget extends StatefulWidget {
  const CounterWidget({Key key, this.ininCounter = 0});

  final int ininCounter;

  @override
  _CounterWidgetState createState() {
    print("TestContainer  CounterWidget createState");
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

  List<Widget> getWrapBtn() {
    return _list
        .map((e) => FlatButton(
            onPressed: () {},
            child: Text(
              e,
              style: TextStyle(backgroundColor: Colors.green),
            )))
        .toList();
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
        child: Column(
      children: [
        // Expanded(
        //   child: Wrap(
        //     verticalDirection: VerticalDirection.down,
        //     children: List.generate(10, (i) {
        //       double w = 50.0 + 10 * i;
        //       return Container(
        //         color: Colors.primaries[i],
        //         height: 50,
        //         width: w,
        //         child: Text('$i'),
        //       );
        //     }),
        //   ),
        // ),
        Container(
          color: Colors.grey,
          width: double.infinity, // 设置container 宽度来充满屏幕
          child: Wrap(
            verticalDirection: VerticalDirection.down,
            alignment: WrapAlignment.spaceBetween,
            children: List.generate(10, (i) {
              double w = 50.0 + 10 * i;
              return Container(
                color: Colors.primaries[i],
                height: 50,
                width: w,
                child: Text('$i'),
              );
            }),
          ),
        ),
        Container(
          color: Colors.red,
          height: 50,
          child: Align(
            alignment: Alignment.topCenter,
            widthFactor: 2,
            heightFactor: 4,
            child: Container(
                child: Text(
                    "widthFactor和heightFactor参数不为null且父组件没有限制大小，此时Align的宽度等于子控件的宽度乘以对应的factor"),
                color: Colors.grey),
          ),
        ),
        Center(
          child: Text("测试Center"),
        ),
        Row(
          children: [Text("测试 row 中直接嵌套text ，过长会报错1231")],
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
                "this is xxxxxx 123",
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
        Row(
          children: [
            Expanded(
              flex:1,
              child: Text("Expanded1"),
            ),
            Expanded(
              flex:1,
              child: Text("Expanded2"),
            ),
            Spacer(flex: 3)
          ],
        ),
        Text("下面是真实项目演示！！"),
        Container(
          width: double.infinity,
          child: Container(
            margin: EdgeInsets.all(10.0),
            child: Container(
              padding: EdgeInsets.all(10.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    "识别结果",
                    textAlign: TextAlign.left,
                    style: TextStyle(color: Color.fromRGBO(153, 153, 153, 1)),
                  ),
                  Row(
                    children: [Text("123"), Text("123")],
                  ),
                  Container(
                    // color: Color.fromARGB(255,255, 238, 234),
                    decoration: BoxDecoration(
                        color: Color.fromARGB(255, 255, 238, 234),
                        borderRadius: BorderRadius.all(Radius.circular(10.0))),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Image.asset("images/question.png",
                            width: 20, height: 20),
                        Text(
                          "该条码在系统中绑定了3个SKU，请仔细核对后再操作112312313123",
                          style: TextStyle(fontSize: 10),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
              decoration: BoxDecoration(
                borderRadius: BorderRadius.all(Radius.circular(10.0)),
                color: Colors.white,
              ),
            ),
          ),
        )
      ],
    ));
  }
}

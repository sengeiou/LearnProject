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
                "123123",
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
          children: [
            Text(
              "this is tag1",
              style: TextStyle(fontSize: 32, color: Colors.red),
            ),
            Text(
              "this is tag2123123",
              style: TextStyle(fontSize: 32, color: Colors.red),
            ),
            Text(
              "this is tag3",
              style: TextStyle(fontSize: 32, color: Colors.red),
            )
          ],
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
        )
      ],
    ));
  }
}

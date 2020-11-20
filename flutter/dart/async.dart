



Future<String> lookupVersion() async{
   return Future.delayed(Duration(seconds: 3),(){
      return "this msg from delayed";
    });
}

Future  checkVersion() async{
    await lookupVersion()
      .then((value) => print("${value}"))
      .catchError((exception)=>{print("${exception}")});
}

// 创建stream

//https://blog.csdn.net/yingshukun/article/details/100855253
void main(){
    var list = [1,2,3,4];
    var stream = Stream.fromIterable(list);
    var stream1 = Stream.fromIterable(list);
    var stream2 = Stream.fromIterable(list);
    var streamFromFuture = Stream.fromFuture(lookupVersion());
    var streamFromValue = Stream.value(1);
    var streamEmpty = Stream.empty();
    
    print("$stream");
    print("$streamFromFuture");
    print("$streamFromValue");
    print("$streamEmpty");

    // 监听   forEach/listen
    // stream.forEach((element) {
    //     print("$element");
    // });

    stream.listen((event) {
        print("$event");
    },
    onError: (e){ print("error---${e}");},
    onDone:(){ print("done");}
    );


    // 限制操作    限制数量take(num)   根据表达式显示takeWhile()

    stream1 =  stream1.takeWhile((element)  =>  element < 3);


    // 跳过   skip   skipWhile()

    //Future<List<T>> toList() 表示将Stream中所有数据存储在List中
    var sList = stream2.map((event) => event *event).toList();
    sList.then((value) => print("${value}"));





    checkVersion();
}
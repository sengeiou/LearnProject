
// import 'dart:asnyc';
// import 'dart:html';


Future<String> lookupVersion() async{
   return Future.delayed(Duration(seconds: 3),(){
      return "this msg from delayed";
    });
}

// 两种方式获取 lookupVersion ,   future  和   async+await
void checkVersion1(){
    lookupVersion()
      .then((value) => print("${value}"))
      .catchError((exception)=>{print("${exception}")});
}
//await关键字必须在async函数内部使用
// 调用async函数必须使用await关键字
void checkVersion2() async{
    String name  = await lookupVersion();
    print("$name");
}



// 创建stream

//https://blog.csdn.net/yingshukun/article/details/100855253
void main() async{
    // var list = [1,2,3,4];
    // var stream = Stream.fromIterable(list);
    // var stream1 = Stream.fromIterable(list);
    // var stream2 = Stream.fromIterable(list);
    // var streamFromFuture = Stream.fromFuture(lookupVersion());
    // var streamFromValue = Stream.value(1);
    // var streamEmpty = Stream.empty();
    
    // print("$stream");
    // print("$streamFromFuture");
    // print("$streamFromValue");
    // print("$streamEmpty");

    // // 监听   forEach/listen
    // // stream.forEach((element) {
    // //     print("$element");
    // // });

    // stream.listen((event) {
    //     print("$event");
    // },
    // onError: (e){ print("error---${e}");},
    // onDone:(){ print("done");}
    // );


    // // 限制操作    限制数量take(num)   根据表达式显示takeWhile()

    // stream1 =  stream1.takeWhile((element)  =>  element < 3);


    // // 跳过   skip   skipWhile()

    // //Future<List<T>> toList() 表示将Stream中所有数据存储在List中
    // var sList = stream2.map((event) => event *event).toList();
    // sList.then((value) => print("${value}"));


    // StreamController streamController = StreamController();


    checkVersion1();
    checkVersion2();

}
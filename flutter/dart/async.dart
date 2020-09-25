



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

void main(){
    checkVersion();
}
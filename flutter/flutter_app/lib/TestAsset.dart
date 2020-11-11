import 'package:flutter/material.dart';

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

  void getJsonAsset(BuildContext context) {
    DefaultAssetBundle.of(context)
        .loadString("files/test1.json")
        .then((value) => setState(() {
              localJSONString = value;
            }));
  }

  var list =
  ["https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2649742991,3793846901&fm=26&gp=0.jpg", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3940925933,2751582199&fm=15&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3683728958,1279653287&fm=26&gp=0.jpg", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2605922652,458991881&fm=26&gp=0.jpg", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2807791568,409822292&fm=26&gp=0.jpg", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2861213490,78710864&fm=26&gp=0.jpg", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1683988646,2816156624&fm=15&gp=0.jpg", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2208267665,1918724031&fm=15&gp=0.jpg", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2442713800,2320869158&fm=26&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2532305570,3516123053&fm=11&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1711785878,3345533291&fm=15&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2833178721,1642407514&fm=15&gp=0.jpg", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3553160428,3938092081&fm=26&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1718757698,1523487151&fm=26&gp=0.jpg", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2973516105,648006623&fm=26&gp=0.jpg", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=15771039,938612163&fm=26&gp=0.jpg", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2063913532,1318786873&fm=26&gp=0.jpg", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2523435862,4084638793&fm=15&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2854357379,1161162658&fm=15&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2003843587,135804224&fm=26&gp=0.jpg", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2292817232,2341878625&fm=15&gp=0.jpg", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3794296723,1639989746&fm=26&gp=0.jpg", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2472681224,4218660278&fm=15&gp=0.jpg", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3577809152,118865105&fm=26&gp=0.jpg", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3573878204,601394949&fm=26&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=236757606,2333674191&fm=15&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1349598252,2124365805&fm=15&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3046549284,503149797&fm=11&gp=0.jpg", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2477466780,1533506913&fm=26&gp=0.jpg", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1275920936,2476406654&fm=26&gp=0.jpg"];

  ListView buildList({num size = 100}) {
    return ListView.builder(
      itemCount: list.length,
      itemBuilder: (BuildContext context, int index) {
        //
        return ListTile(title: Column(
            children: [
              Text("${index}"),
              Image.network(list[index],width: 300, height: 300,fit:BoxFit.cover)

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

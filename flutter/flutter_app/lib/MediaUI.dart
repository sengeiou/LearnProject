import 'package:flutter/material.dart';


class MediaUI extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    // throw UnimplementedError();
    return Scaffold(
      appBar: AppBar(
        title: Text("this is title"),
      ),
      body: Center(child: ContentWidget()),
    );
  }
}



class ContentWidget extends StatefulWidget {
  @override
  _Test2State createState() => _Test2State();


}

class _Test2State extends State<ContentWidget> {
  @override
  Widget build(BuildContext context) {
    return Container(
        child: Column(
          children: [
            Image.network("https://i2.hdslb.com/bfs/face/773b93a3e67e64d6214e523e473bae196f99c7d1.jpg@52w_52h.webp",
              fit: BoxFit.cover,
              width: 100,
              height: 200,
            ),
            Image.asset("images/test.jpg",
              width: 100,
              height: 100,
            )

            
          ],
        ),
      
    );
  }
}

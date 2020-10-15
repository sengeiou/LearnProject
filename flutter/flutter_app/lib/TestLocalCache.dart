import 'dart:io';

import 'package:flutter/material.dart';
import 'package:path_provider/path_provider.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class TestLocalCache extends StatelessWidget {
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
  String localCachetring = "";
  String localFileString = "";
  String SQLiteString = "";

  void setCache() async {
    SharedPreferences sp = await SharedPreferences.getInstance();
    await sp.setString("name", "zeg shabi!!!");
  }

  void getCache() async {
    SharedPreferences sp = await SharedPreferences.getInstance();
    String name = await sp.get("name");
    setState(() {
      localCachetring = name;
    });
  }

  //
  void listFileCache() async {
    Directory tempDir = await getTemporaryDirectory();
    String tempPath = tempDir.path;

    List<FileSystemEntity> fileList = await tempDir.listSync();

    var list = [];
    for (FileSystemEntity entity in fileList) {
      list.add(entity.path);
    }
    // localFileString
    setState(() {
      localFileString = "${tempPath} \n the child dirs \n ${fileList}";
    });
  }

  void createFileCache() async {
    Directory tempDir = await getTemporaryDirectory();
    String tempPath = tempDir.path;
    File file = File(tempPath + "/" + "123.txt");
    file.create(recursive: true);
  }

  void getFileCache() async {
    Directory tempDir = await getTemporaryDirectory();
    String tempPath = tempDir.path;

    Directory appDocDir = await getApplicationDocumentsDirectory();
    String appDocPath = appDocDir.path;

    setState(() {
      localFileString = "文件缓存路径:\n  ${tempPath} \n ${appDocPath}";
    });
  }

  void getSQLite() async {
    var databasesPath = await getDatabasesPath();
    String path = join(databasesPath, 'demo.db');
    setState(() {
      SQLiteString = "getSQLite databasesPath : \n ${path}";
    });
  }

  void createSQLite() async{
    var databasesPath = await getDatabasesPath();
    String path = join(databasesPath, 'demo.db');
    Database database = await openDatabase(path, version: 3,
        onCreate: (Database db, int version) async {
          // When creating the db, create the table
          print("the database version ${version}");
          await db.execute(
              'CREATE TABLE Test (id INTEGER PRIMARY KEY, name TEXT, value INTEGER, num REAL)');
        });



  }



  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Container(
          padding: EdgeInsets.all(10),
          child:
              Text("SharedPreferences缓存", style: TextStyle(color: Colors.red)),
        ),
        Row(
          children: [
            FlatButton(onPressed: setCache, child: Text("setCache")),
            FlatButton(onPressed: getCache, child: Text("getCache")),
          ],
        ),
        Text("${localCachetring}"),
        Container(
          padding: EdgeInsets.all(10),
          child: Text("文件缓存", style: TextStyle(color: Colors.red)),
        ),
        Wrap(
          children: [
            FlatButton(onPressed: listFileCache, child: Text("listFileCache")),
            FlatButton(onPressed: getFileCache, child: Text("getFileCache")),
            FlatButton(
                onPressed: createFileCache, child: Text("createFileCache")),
          ],
        ),
        Text("${localFileString}"),
        Container(
          padding: EdgeInsets.all(10),
          child: Text("SQLite缓存", style: TextStyle(color: Colors.red)),
        ),
        Wrap(
          children: [
            FlatButton(onPressed: getSQLite, child: Text("getSQLite")),
            FlatButton(onPressed: createSQLite, child: Text("createSQLite")),
          ],
        ),
        Text("${SQLiteString}"),
      ],
    );
  }
}

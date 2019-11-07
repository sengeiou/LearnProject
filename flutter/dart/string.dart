void main() {
  var name = "COCOCA  \n";
  print("the name isEmpty is ${name.isEmpty}");
  print("${name.trim()}");
  print("${name.trim().endsWith('A')}");

  print("the name subString 0-3 ${name.substring(0, 3)}");
  print("the name *3 = ${name.trim() * 3}");

  print("the name padleft 10 is ${name.trim().padLeft(10, 'A')}");

  print("the name replacerange is ${name.trim().replaceRange(0, 2, "TTTTT")}");

  print("the name to lowercase is ${name.trim().toLowerCase()}");

//    var name1 = 'ALPHABET'.toLowerCase();
}

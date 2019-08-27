
void main(){

    List list1 = [1,2,3];

    var list2 = new List();
    list2.add(1);

    list2.length;
    list2.isEmpty;
    list2.isNotEmpty;

    list2.addAll([2,3,4,5]);
    var result = list2.reversed;
    print(result);

    print(list2.indexOf(2));

    print(list2.remove(1));

    list2.fillRange(0, 1,999);
    print(list2);  

    list2.fillRange(0, 2,[8988,909]);
    print(list2); 

    print(list2.join("--"));


    var set  = new Set();
    set.add(1);
    set.add(1);
    set.add(3);
    set.add(4);
    set.add(5);

    print(set);

    var m = {
      'age': 12
    };

    var map  = new Map();
    map['name']= "co";
    map['age'] = 12;

    print(map.keys.toList());

    var a1= map.containsKey("name");
    var a2 = map.containsValue(12);
    print("object result = ${a1}  ${a2}");

    var a3 = list1.map((value) {
        return value * 2; 
    });
    print(a3);
}
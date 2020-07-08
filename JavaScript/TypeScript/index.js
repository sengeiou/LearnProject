// 接口初步认识
function printLabel(labelObj) {
    console.log(labelObj.label);
}
var myObj = { size: 10, label: "size is 10" };
printLabel(myObj);
function printLabel1(labeler) {
    console.log(labeler.label);
}
printLabel1(myObj);
var myObj1 = { size: 10 }; //删掉label属性，下面的代码编译期就报错
var p1 = { x: 12, y: 123 };
// p1.x = 123
//Readonly 类型的 array
var array = [1, 2, 3];
var ro = array;
function test1(config) {
    if (config.color) {
        console.log(config.color);
    }
    if (config.width) {
        console.log(config.width);
    }
}
//加入输入错误的，比如笔误colour，编译将无法通过
test1({ color: 'red', width: 1123 });
//绕开这些检查非常简单。 最简便的方法是使用类型断言：
test1({ colour: 'red', width: 1123 });
//在属性中加入 age，编译也无法通过 ，可以在接口中加入[propName: string]: any;
//[propName: string]: any 表示加入任意数量的其它属性
test1({ color: 'red', width: 1123, age: 123 });
//绕开这些检查的另一个办法。就是将这个对象赋值给一个另一个变量
var newObj = { xxx: 11, name: "111" };
test1(newObj);
var qu = function (a, b) {
    return a == b;
};
var qu1 = function (x, y) {
    //  类型会自动判断，参数名也不用一致
    return x == y;
};
var myArray = ["Hello", "ccooa"];
var s = myArray[0];
var Clock = /** @class */ (function () {
    function Clock() {
    }
    Clock.prototype.setTime = function (d) {
        this.currentTime = d;
    };
    return Clock;
}());
var square = {};
square.length = 10;
square.color = "red";

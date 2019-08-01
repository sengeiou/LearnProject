var isDone = false;
var num1 = 123;
var cocoaname = "cocoa ${num1}";
console.log(cocoaname);
var list1 = [1, 2, 3];
var list2 = ['12', '22'];
var x;
x = ['cocoa', 12];
console.log(x[0]);
console.log(x[1]);
// console.log(x[444]);
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
var c = Color.Red;
// void 
function log() {
    console.log("this s my warning log");
}
var unusable = undefined;
// null and undefined
var n = null;
var u = undefined;
function fail() {
    return new Error("something failed");
}
create({ name: 'cocoa' });
//  类型判断
// 
var msg = "this is sample msg";
var msgLength = msg.length;
var a = parseInt(msg);

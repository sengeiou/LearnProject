// funtion add(x,y){
//     return x + y
// }
// let myAdd = function(a, b){
//     return a + b 
// }
// ts 的写法
function add(a, b) {
    return a + b;
}
var myAdd = function (a, b) {
    return a + b;
};
// 完整的函数类型
var myAdd1 = function (a, b) {
    return a + b;
};
console.log(myAdd1(10, 10));
function buildName(firstName, lastName) {
    if (lastName) {
        return firstName + " " + lastName;
    }
    return firstName;
}
console.log(buildName("cocoa"));
function buildName1(firstName, lastName) {
    if (lastName === void 0) { lastName = 'welcome!'; }
    return firstName + " " + lastName;
}
console.log(buildName1("cocoa")); //cocoa welcome!
console.log(buildName1("cocoa", undefined)); //cocoa welcome!
console.log(buildName1("cocoa", null)); //cocoa null
//剩余参数
function buildName3(name) {
    var otherInfo = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        otherInfo[_i - 1] = arguments[_i];
    }
    console.log(name + " " + otherInfo.join(" "));
}
console.log(buildName3("cocoa", "11", "22", "333"));

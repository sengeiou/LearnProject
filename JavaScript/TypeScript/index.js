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
function test1(config) {
    if (config.color) {
        console.log(config.color);
    }
    if (config.width) {
        console.log(config.width);
    }
}
test1({ color: 'red', width: 1123 });

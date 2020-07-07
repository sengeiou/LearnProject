// // 接口初步认识
function printLabel(labelObj) {
    console.log(labelObj.label);
}
var myObj = { size: 10, label: "size of 10 object" };
printLabel(myObj);
printLabel({ label: "cocoa" }); // 这样的写法不能再增加新的属性
function testOption(labelObj) {
    if (labelObj.age) {
        console.log("testOption=" + labelObj.age);
    }
    else {
        console.log("sorry age prop not found");
    }
}
testOption(myObj);

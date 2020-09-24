// // 接口初步认识

// function printLabel(labelObj :{label:string}){
//     console.log(labelObj.label);
// }

// let myObj = {size: 10, label: "size is 10"};

// printLabel(myObj);


// // 用interface 重写上面的代码

// interface Labeler{
//     label: string
// }

// function printLabel1(labeler:Labeler){
//     console.log(labeler.label);
// }

// printLabel1(myObj)

// let myObj1 = {size: 10} //删掉label属性，下面的代码编译期就报错
// // printLabel1(myObj1)

// // 不是很明白这里为什么会报错，跳过
// // printLabel1({size: 10, label: "size is 10"})

// interface Pointer{
//     readonly x :number
//     readonly y : number
// }

// let p1 : Pointer = {x:12, y :123}
// // p1.x = 123

// //Readonly 类型的 array
// let array : number[] = [1,2,3]
// let ro : ReadonlyArray<number> = array
// // ro.length = 10
// // ro[1] = 10


// // readonly 和 const
// // readonly作为属性使用， const 作为变量使用




// // 可选类型
// interface Config{
//     color? : string
//     width? : number
//     [propName: string]: any;
// }

// function test1(config:Config){
//        if(config.color){
//            console.log(config.color)
//        } 
//        if(config.width){
//            console.log(config.width)
//        } 
// }
// //加入输入错误的，比如笔误colour，编译将无法通过
// test1({color:'red',width:1123});
// //绕开这些检查非常简单。 最简便的方法是使用类型断言：
// test1({colour:'red',width:1123} as Config);
// //在属性中加入 age，编译也无法通过 ，可以在接口中加入[propName: string]: any;
// //[propName: string]: any 表示加入任意数量的其它属性
// test1({color:'red',width:1123,age:123});

// //绕开这些检查的另一个办法。就是将这个对象赋值给一个另一个变量
// let newObj = {xxx:11,name:"111"}
// test1(newObj);

// // 至此。上面printLabel1 的问题都已经解释了


// // 函数类型
// interface Equals{
//     (a: string, b : string) : boolean
// }

// var qu : Equals = function(a:string, b : string){
//     return a == b
// }

// var qu1 : Equals = function(x, y){  //相对于qu，这是一个简写的方法，
//                                     //  类型会自动判断，参数名也不用一致
//     return x == y
// }

// // 可索引的类型
// interface StringArray{
//     [index : number] : string
// }

// let myArray : StringArray = ["Hello","ccooa"]
// let s : string = myArray[0]


// // 类类型

// interface Dater{
//     currentTime :Date
//     setTime(d: Date)
// }

// class Clock implements Dater{
//     currentTime : Date
//     setTime(d: Date){
//         this. currentTime = d
//     }
// }


// //类静态部分与实例部分的区别
// //当你操作类和接口的时候，你要知道类是具有两个类型的：静态部分的类型和实例的类型。 你会注意到，当你用构造器签名去定义一个接口并试图定义一个类去实现这个接口时会得到一个错误：

// interface ClockConstructor {
//     new (hour: number, minute: number);
// }

// // class Clockxx implements ClockConstructor {
// //     currentTime: Date;
// //     constructor(h: number, m: number) { }
// // }

// // 太烦了，没看明白，跳过


// // 继承接口
// interface Shape{
//     color : string
// }

// interface Square extends Shape{   // 接口可以多继承
//     length : number
// }

// let square = <Square>{}
// square.length = 10
// square.color  = "red"



interface LabelValue{
    label : String;
    age? : number;
}

function printLabel(labelObj : LabelValue){
    console.log(labelObj.label);
}

let myObj = { size: 10 , label: "size of 10 object"}
printLabel(myObj)
printLabel({label:"cocoa"})  // 这样的写法不能再增加新的属性


function testOption(labelObj : LabelValue){
    if(labelObj.age){
        console.log("testOption="+labelObj.age);
    }else{
        console.log("sorry age prop not found");
    }

}
testOption(myObj);


// 只读属性
interface Point{
    readonly x : number;
    readonly y : number;
}

let p1 : Point = {x: 1 , y: 1}
// p1.x = 10   //error!! readonly 



let readonlyArray : ReadonlyArray<number> = [1,2,3]
// readonlyArray[1] = 10  // error


interface SquareConfig{
    name?: string;
    age?: Number;
}

function test0x2( config: SquareConfig){
    console.log(config);
}

// test0x2({age12312:12, name:"cocoa"})  // 这样的写法，即使age 是可选的，也不能没有这个属性


// 可以绕开这样的检测

test0x2({age12312:123, name:"cocoa"} as SquareConfig)


// 函数类型

interface searchFun{
    (name: string, age: number) : string;
}

let search1 : searchFun ;
search1 = function(name: string , age: number) : string{
    let str = `the name = ${name} the age = ${age}`
    console.log(str)
    return  str
}

search1("cocoa",18)


interface StringArray{
    [index : number] : string   // index 是一种索引，类型是数字
}

var sa : StringArray;
sa = ["1","2","3"]

// function test0x3(sa : StringArray){
//     console.log(sa.lenght);    
// }

// TypeScript支持两种索引签名：字符串和数字




// 类类型

interface ClockInterface{
    date: Date
    setTime(date: Date);
}

class Clock implements ClockInterface{
    setTime(date: Date) {
       this.date = date
    }
    date: Date
}


//类静态部分与实例部分的区别   没看懂



// 继承接口
// 接口也是可以继承自一个或多个接口，多个用逗号隔开
interface Shape{
    name: string
}

interface Square extends Shape{
    color: string
}

let sp = <Square>{}
sp.color="red"
sp.name="sp"




// class Control {
//     private state: any;
// }

// interface SelectableControl extends Control {
//     select(): void;
// }

// class Button extends Control implements SelectableControl {
//     select() { }
// }

// class TextBox extends Control {
//     select() { }
// }

// // 错误：“Image”类型缺少“state”属性。
// class Image implements SelectableControl {
//     select() { }
// }

class Location {

}













// 接口初步认识

function printLabel(labelObj :{label:string}){
    console.log(labelObj.label);
}

let myObj = {size: 10, label: "size is 10"};

printLabel(myObj);


// 用interface 重写上面的代码

interface Labeler{
    label: string
}

function printLabel1(labeler:Labeler){
    console.log(labeler.label);
}

printLabel1(myObj)

let myObj1 = {size: 10} //删掉label属性，下面的代码编译期就报错
// printLabel1(myObj1)

// 不是很明白这里为什么会报错，跳过
// printLabel1({size: 10, label: "size is 10"})

interface Pointer{
    readonly x :number
    readonly y : number
}

let p1 : Pointer = {x:12, y :123}
// p1.x = 123

//Readonly 类型的 array
let array : number[] = [1,2,3]
let ro : ReadonlyArray<number> = array
// ro.length = 10
// ro[1] = 10


// readonly 和 const
// readonly作为属性使用， const 作为变量使用




// 可选类型
interface Config{
    color? : string
    width? : number
    [propName: string]: any;
}

function test1(config:Config){
       if(config.color){
           console.log(config.color)
       } 
       if(config.width){
           console.log(config.width)
       } 
}
//加入输入错误的，比如笔误colour，编译将无法通过
test1({color:'red',width:1123});
//绕开这些检查非常简单。 最简便的方法是使用类型断言：
test1({colour:'red',width:1123} as Config);
//在属性中加入 age，编译也无法通过 ，可以在接口中加入[propName: string]: any;
//[propName: string]: any 表示加入任意数量的其它属性
test1({color:'red',width:1123,age:123});

//绕开这些检查的另一个办法。就是将这个对象赋值给一个另一个变量
let newObj = {xxx:11,name:"111"}
test1(newObj);

// 至此。上面printLabel1 的问题都已经解释了


// 函数类型
interface Equals{
    (a: string, b : string) : boolean
}

var qu : Equals = function(a:string, b : string){
    return a == b
}

var qu1 : Equals = function(x, y){  //相对于qu，这是一个简写的方法，
                                    //  类型会自动判断，参数名也不用一致
    return x == y
}

// 可索引的类型
interface StringArray{
    [index : number] : string
}

let myArray : StringArray = ["Hello","ccooa"]
let s : string = myArray[0]



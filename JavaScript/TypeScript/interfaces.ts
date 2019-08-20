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

// 可选类型
interface Config{
    color? : string
    width? : number
}

function test1(config:Config){
       if(config.color){
           console.log(config.color)
       } 
       if(config.width){
           console.log(config.width)
       } 
}


test1({color:'red',width:1123});

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



test1({color_1:'red',width_1:1123} as Config);


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





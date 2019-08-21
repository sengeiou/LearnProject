// funtion add(x,y){
//     return x + y
// }

// let myAdd = function(a, b){
//     return a + b 
// }

// ts 的写法

function add(a: number , b : number) : number{
    return a + b
}

let myAdd = function(a: number , b : number): number{
    return a + b 
}

// 完整的函数类型
let myAdd1 : (a: number, b: number) => number = 
            function(a: number, b : number):number{  //这里的类型可以省略不写，推断出来
                return a + b
            }

console.log(myAdd1(10,10));


function buildName(firstName: string,lastName? : string){
        if(lastName){
            return firstName +" "+ lastName
        }
        return firstName
}

console.log(buildName("cocoa"))

function buildName1(firstName: string,lastName = 'welcome!'){
    return firstName +" "+ lastName
}

console.log(buildName1("cocoa"))     //cocoa welcome!
console.log(buildName1("cocoa",undefined)) //cocoa welcome!
console.log(buildName1("cocoa",null))    //cocoa null


//剩余参数   ... 数组类型
function buildName3(name: string, ...otherInfo: string[]){
    console.log(name+" "+ otherInfo.join(" "))
}
buildName3("cocoa","11","22","333")

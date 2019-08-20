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

// 





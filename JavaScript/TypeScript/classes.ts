// // ts 中的继承

// class Animal {
//     // 属性和方法默认的修饰符都是 public ，
//     // 一旦申明为private ，则不能在类的外部访问
//     name : string
    
//     constructor(name : string) {
//         this.name = name
//     }
   
//     move(dis:number = 0){
//         console.log("${this.name} move ${dis}");
//     }
// }

// class Dog extends Animal{

//     constructor(name :string){
//         super(name);
//     }

//     move(dis:number = 45){
//         console.log("dog start move")
//         super.move(dis)
//     }

//     back(){
//         console.log("back");
//     }
// }

// const dog  = new Dog("ccc")
// dog.move()
// dog.back()





//  new2


class Person{
    hello(name: string):string {
        return "hello "+ name
    }
}

class Cocoa extends Person{

}

let cococa : Cocoa = new Cocoa()
const result = cococa.hello("yeln")
console.log(result)


class Animal {
    name: string;
    constructor(name: string){
        this.name = name
    }

    move(distance : number = 0){
        console.log(`${this.name} moved ${distance}`)
    }
}

class Snake extends Animal {
    constructor(name: string){
        super(name)
    }
    move(distance: number){
        console.log("this is moved @ Snake");
        super.move(distance)
    }
}

let s = new Snake("coco")
s.move(10)


// 修饰符默认都是public 的

// 当成员被定义为private时， 就不能在类的外部访问

class Parent{
    private name : string = "Parent";
}

class Child  extends Parent{
    constructor(){
        super()
        // private 修饰的属性在子类中不能访问
        // 而 protected 则可以，protected别的行为和prv 一致
        // console.log(this.name);  
    }
}


// new Parent().name   // 报错
new Child()






// readonly
// readonly 的属性如果没有值，必须在构造函数中赋值
class Outopus {
    readonly name : string;
    readonly numberOfLngs : number = 19

    constructor(theName : string ){
        this.name = theName;
    }
}



//存取器

class Employee{
    private _fullname: string;

    get fullName(): string{
        return this._fullname
    }

    set fullName(nName: string){
        console.log("the new name will be set"+ nName)
        this._fullname = nName        
    }
}

let eml = new Employee()
eml.fullName = "cocoa"
console.log(eml.fullName)







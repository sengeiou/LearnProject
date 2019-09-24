// ts 中的继承

class Animal {
    // 属性和方法默认的修饰符都是 public ，
    // 一旦申明为private ，则不能在类的外部访问
    name : string
    
    constructor(name : string) {
        this.name = name
    }
   
    move(dis:number = 0){
        console.log("${this.name} move ${dis}");
    }
}

class Dog extends Animal{

    constructor(name :string){
        super(name);
    }

    move(dis:number = 45){
        console.log("dog start move")
        super.move(dis)
    }

    back(){
        console.log("back");
    }
}

const dog  = new Dog("ccc")
dog.move()
dog.back()


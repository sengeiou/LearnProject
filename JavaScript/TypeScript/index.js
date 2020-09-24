var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
var Person = /** @class */ (function () {
    function Person() {
    }
    Person.prototype.hello = function (name) {
        return "hello " + name;
    };
    return Person;
}());
var Cocoa = /** @class */ (function (_super) {
    __extends(Cocoa, _super);
    function Cocoa() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return Cocoa;
}(Person));
var cococa = new Cocoa();
var result = cococa.hello("yeln");
console.log(result);
var Animal = /** @class */ (function () {
    function Animal(name) {
        this.name = name;
    }
    Animal.prototype.move = function (distance) {
        if (distance === void 0) { distance = 0; }
        console.log(this.name + " moved " + distance);
    };
    return Animal;
}());
var Snake = /** @class */ (function (_super) {
    __extends(Snake, _super);
    function Snake(name) {
        return _super.call(this, name) || this;
    }
    Snake.prototype.move = function (distance) {
        console.log("this is moved @ Snake");
        _super.prototype.move.call(this, distance);
    };
    return Snake;
}(Animal));
var s = new Snake("coco");
s.move(10);
// 修饰符默认都是public 的
// 当成员被定义为private时， 就不能在类的外部访问
var Parent = /** @class */ (function () {
    function Parent() {
        this.name = "Parent";
    }
    return Parent;
}());
var Child = /** @class */ (function (_super) {
    __extends(Child, _super);
    function Child() {
        return _super.call(this) || this;
        // private 修饰的属性在子类中不能访问
        // 而 protected 则可以，protected别的行为和prv 一致
        // console.log(this.name);  
    }
    return Child;
}(Parent));
// new Parent().name   // 报错
new Child();
// readonly
// readonly 的属性如果没有值，必须在构造函数中赋值
var Outopus = /** @class */ (function () {
    function Outopus(theName) {
        this.numberOfLngs = 19;
        this.name = theName;
    }
    return Outopus;
}());
//存取器
var Employee = /** @class */ (function () {
    function Employee() {
    }
    Object.defineProperty(Employee.prototype, "fullName", {
        get: function () {
            return this._fullname;
        },
        set: function (nName) {
            console.log("the new name will be set" + nName);
            this._fullname = nName;
        },
        enumerable: false,
        configurable: true
    });
    return Employee;
}());
var eml = new Employee();
eml.fullName = "cocoa";
console.log(eml.fullName);

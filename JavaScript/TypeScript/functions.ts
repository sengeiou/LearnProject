// // funtion add(x,y){
// //     return x + y
// // }

// // let myAdd = function(a, b){
// //     return a + b 
// // }

// // ts 的写法

// function add(a: number , b : number) : number{
//     return a + b
// }

// let myAdd = function(a: number , b : number): number{
//     return a + b 
// }

// // 完整的函数类型
// let myAdd1 : (a: number, b: number) => number = 
//             function(a: number, b : number):number{  //这里的类型可以省略不写，推断出来
//                 return a + b
//             }

// console.log(myAdd1(10,10));


// function buildName(firstName: string,lastName? : string){
//         if(lastName){
//             return firstName +" "+ lastName
//         }
//         return firstName
// }

// console.log(buildName("cocoa"))

// function buildName1(firstName: string,lastName = 'welcome!'){
//     return firstName +" "+ lastName
// }

// console.log(buildName1("cocoa"))     //cocoa welcome!
// console.log(buildName1("cocoa",undefined)) //cocoa welcome!
// console.log(buildName1("cocoa",null))    //cocoa null


// //剩余参数   ... 数组类型
// function buildName3(name: string, ...otherInfo: string[]){
//     console.log(name+" "+ otherInfo.join(" "))
// }
// buildName3("cocoa","11","22","333")



// // this 箭头


// // 会报错
// // let deck = {
// //     suits : ["hearts", "spades", "clubs", "diamonds"],
// //     cards : Array(52),
// //     createCardPicker : function(){
// //         return function (){
// //             console.log(this);
// //             // 这里会报错，因为this 对象并不是deck    
// //             return {suit: this.suits[1]}; 
// //         }
// //     }
// // }

// // let cardPicker = deck.createCardPicker();
// // let obj = cardPicker();
// // console.log(obj.suit);



// let deck1 = {
//     suits : ["hearts", "spades", "clubs", "diamonds"],
//     cards : Array(52),
//     createCardPicker : function(){
//         return () => {
//             console.log(this);
//             // 这里会报错，因为this 对象并不是deck    
//             return {suit: this.suits[1]}; 
//         }
//     }
// }

// let cardPicker1 = deck1.createCardPicker();
// let obj1 = cardPicker1();
// console.log(obj1.suit);





// new2
function add(x,y){
    return x+ y    
}

console.log(add(1,2));


function addInTs(x: number, y: number) : number{
    return x + y
}

let myAdd = function(x: number, y: number): number {
    return x + y
}

console.log(myAdd(1,2));
console.log(addInTs(1,2))

// 完整的函数类型
//第二部分是返回值类型。 对于返回值，我们在函数和返回值类型之前使用( =>)符号，使之清晰明了。 
//如之前提到的，返回值类型是函数类型的必要部分，如果函数没有返回任何值，你也必须指定返回值类型为 void而不能留空
var funAdd : (x:number, y : number) => number = function(x: number , y: number) : number{
    return x + y;
}

// 如果不主动写函数类型，ts 也会进行自动推断

console.log(funAdd(12,21));


// 可选参数


function test1(name: string , age?: number){
    if(age){
        console.log(name + age);
    }else{
        console.log(name)
    }
}

test1("ccooa")
test1("cocoa",12)


function bindName(name: string = "cocoa"){
    console.log("my name is " + name);
}


bindName()
bindName(undefined)
bindName("yelpn")


// 剩余参数


function mulParams(name: string, ...params: number[]){
     console.log(params)   
}


mulParams("cocoa", 1,2,3)


let deck = {
    suits: ["hearts", "spades", "clubs", "diamonds"],
    cards: Array(52),
    createCardPicker: function() {
        return function() {
            let pickedCard = Math.floor(Math.random() * 52);
            let pickedSuit = Math.floor(pickedCard / 13);
            console.log(this) // 这里的this 已经变成了window 对象 ，而不是deck
            return {suit: this.suits[pickedSuit], card: pickedCard % 13};
        }
    }
}


let cardPicker = deck.createCardPicker();
// cardPicker();  // 这里会报错


// let deckNew = {
//     suits: ["hearts", "spades", "clubs", "diamonds"],
//     cards: Array(52),
//     createCardPicker: function() {
//         return ()=> {
//             let pickedCard = Math.floor(Math.random() * 52);
//             let pickedSuit = Math.floor(pickedCard / 13);
//             console.log(this) 
//             return {suit: this.suits[pickedSuit], card: pickedCard % 13};
//         }
//     }
// }


// let cardPickerNew = deckNew.createCardPicker();
// cardPickerNew()



function f(this: void) {
    // make sure `this` is unusable in this standalone function
}

interface Card1 {
    suit: string;
    card: number;
}
interface Deck1 {
    suits: string[];
    cards: number[];
    createCardPicker(this: Deck1): () => Card1;
}
let deck1: Deck1 = {
    suits: ["hearts", "spades", "clubs", "diamonds"],
    cards: Array(52),
    // NOTE: The function now explicitly specifies that its callee must be of type Deck
    createCardPicker: function(this: Deck1) {
        return () => {
            let pickedCard = Math.floor(Math.random() * 52);
            let pickedSuit = Math.floor(pickedCard / 13);

            return {suit: this.suits[pickedSuit], card: pickedCard % 13};
        }
    }
}

let cardPicker1 = deck1.createCardPicker();
let pickedCard1 = cardPicker1();

alert("card: " + pickedCard1.card + " of " + pickedCard1.suit);



// 函数回调参数里使用this
interface UIElement{
    addClickListener(onClick: (this: void , e : Event) => void) : void;
}

function click(this: void , e: Event) : void{
    console.log("click function ");
    console.log(this);
    console.log(e);
}

// let element  =  new UIElement()


// class Button implements UIElement{
    
//     addClickListener(onClick: (this: void, e: Event) => void): void {
//         // onClick(e)
//     }
// }


// let button = new Button();
// button.addClickListener(click)








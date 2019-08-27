class Base{
     name :string = "base"
     constructor(name :string) {
         this.name = name 
     }  
     test(){

     }
}

class A extends Base{
    constructor(name :string) {
       super(name)
    }     
}


class B extends Base{
    constructor(name :string) {
        super(name)
    }     
}

function test(b : Base[]){
    //  b.test();
}


let a = new A('A');
console.log(a.name);



// let arr = [new A('A'), new B('B')];
// console.log(typeof arr);
// // test(arr[1]);

// let arr1 : Base[] = [new A('A'), new B('B')];
// console.log(typeof arr1);
// // test(arr1[1]);


//定义一个identity函数。 这个函数会返回任何传入它的值。 你可以把这个函数当成是 echo命令。
function identity(arg) {
    return arg;
}
//使用any类型会导致这个函数可以接收任何类型的arg参数，这样就丢失了一些信息：传入的类型与返回的类型应该是相同的。如果我们传入一个数字，我们只知道任何类型的值都有可能被返回。
function identityUseGeneric(arg) {
    return arg;
}
var out1 = identityUseGeneric("123");
console.log(typeof out1);
var out2 = identityUseGeneric(123);
console.log(typeof out2);
var out3 = identityUseGeneric({});
console.log(typeof out3);
// interface Logger{
//     name : string
// }
// function doLog<T extends Logger>( log : T ) : T{
//     console.log(log.name);
//     return log;
// }
// doLog({name:'cocoa',age:123});
//在泛型里使用类类型  没看懂啊！！！
function test(t) {
    return t;
}
var t1123 = test;
var myIdentity = test;

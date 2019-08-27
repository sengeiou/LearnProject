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
var Base = /** @class */ (function () {
    function Base(name) {
        this.name = "base";
        this.name = name;
    }
    Base.prototype.test = function () {
    };
    return Base;
}());
var A = /** @class */ (function (_super) {
    __extends(A, _super);
    function A(name) {
        return _super.call(this, name) || this;
    }
    return A;
}(Base));
var B = /** @class */ (function (_super) {
    __extends(B, _super);
    function B(name) {
        return _super.call(this, name) || this;
    }
    return B;
}(Base));
function test(b) {
    //  b.test();
}
var a = new A('A');
console.log(a.name);
// let arr = [new A('A'), new B('B')];
// console.log(typeof arr);
// // test(arr[1]);
// let arr1 : Base[] = [new A('A'), new B('B')];
// console.log(typeof arr1);
// // test(arr1[1]);

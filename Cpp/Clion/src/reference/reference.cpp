//
// Created by jun shen on 2020/11/5.
//
#include "reference.h"

void change(int &a ,int &b ){
    cout<<&a<<endl;
    int temp  = a;
    a = b;
    b = temp;
}

// 不要返回局部变量的引用
int& getReference(){
    int a  = 10;
    return a ;
}


void referenceTest() {
    //引用在C++ 内部实现是一个指针常量

    int x  = 11;
    int a = 10;
    int &b = a;

    // 引用必须初始化  ,就是一次性初始化好，错误的例子   int &b ;    b = a;
    // 引用在初始化后，就不可以改变了,     错误的例子   &b = x;


    // 给变量起了别名
    cout << b << endl;


    cout<<"-------------"<<endl;
    //引用做为参数，形参改变实参（类似地址传递）
    // 引用作为函数传参类型能避免拷贝；
    //  可以简化指针修改实参
    int te = 10;
    int xe = 20;
    change(te,xe);
    cout<<&te<<endl;    // 看下引用传递的地址
    cout<< te << endl;
    cout<< xe << endl;

    cout<<"-------------"<<endl;
    //不要返回局部变量的引用, 还有指针，（如果非要这么做，可以提升变量的作用域，加个static）
    int &re = getReference();
    cout<< re <<endl;    // 10
    cout<< re <<endl;    // error value
    cout<< re <<endl;


    // 引用本身需要一个合法的内存空间，所以下面这行代码错误
//    int& aaa = 1000;
    // 但是加上 const , 就能正常运行， 编译器会帮助优化
    const int& bbb = 1000;

    //加上const  ，可以修饰方法中的形参，使得形参不能被修改


}
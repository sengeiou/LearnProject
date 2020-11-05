//
// Created by jun shen on 2020/11/5.
//
#include "reference.h"

void change(int &a ,int &b ){
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
    //  可以简化指针修改实参，（指针传递的时候貌似也是进行了拷贝，而引用貌似没有？？？ ）
    int te = 10;
    int xe = 20;
    change(te,xe);

    cout<< te << endl;
    cout<< xe << endl;

    cout<<"-------------"<<endl;
    //不要返回局部变量的引用
    int &re = getReference();
    cout<< re <<endl;    // 10
    cout<< re <<endl;    // error value
    cout<< re <<endl;



    //94



}
#include <stdio.h>

// const 修饰指针
int main(){

    test1();
    test2();

    return 0;   
}

void test1(){
    int a  = 10;
    int b = 20;
    // const 修饰指针类型，可以修改指针变量的值，不可以修改指针指向内存空间的值
    const int* p = &a;
    p = &b;   //ok
    *p = 1000;   //error
}

void test2(){
    int a = 10;
    int b = 20;
    // const 修饰指针变量，则不能改变指针变量的值，可以修改指针指向内存空间的值
    int* const p = &a;
    p = &b ;  // error
    *p = 2;   // ok
}

void test3(){
    int a = 10;
    int b = 20;
    // const 修改指针类型 和变量 ，则都不能修改
    const int* const p = &a;
    p = &b ;  // error
    *p = 2;   // ok
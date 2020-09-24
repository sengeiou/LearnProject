//
// Created by jun shen on 2020/4/19.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "test.h"




// 全局变量 在函数外部定义的变量
// 作用域：整个程序，外部文件使用需要申明   extern
// 生命周期：从程序创建到程序销毁
// 存储在数据区
int grobalA = 10;

void test1(){
    int* pp = (int*) malloc(sizeof(int)*10);
    memset(pp,1, sizeof(int)*10);
    for (int i = 0; i < 10 ; ++i) {
        printf("=====%d\n",*(pp+i));
    }
}


void testLifecycle(){


    // 局部变量 在函数内部定义的变量
    // 作用域： 函数内部
    // 生命周期： 从函数创建到结束
    // ** auto用于在函数中修饰变量为自动变量，且可省略。auto不能修饰全局变量，因为自动变量只能存在于函数内。
    auto int a  = 10;

}



void memory_main(){

    test1();




    int* p = (int*)malloc(sizeof(int));

    *p = 100;

    printf("the p = %d\n",*p);
    printf("the &p = %p\n",p);




    // 局部变量和全局变量的测试
    testGrobal();
    grobalA= 1111;
    testGrobal();

    //如果局部变量和全局变量同名，取最近的变量
    int grobalA = 2222;
    printf("the grobalA = %d \n", grobalA);





}


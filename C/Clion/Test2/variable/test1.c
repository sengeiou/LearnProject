//
// Created by Administrator on 2020/5/13.
//
#include <stdio.h>

#define DEFINE_VAR_A 10

// 全局变量 在函数外部定义，存储在数据区
// 作用域是整个项目中的所有文件，在其他文件中使用，必须要申请
// 生命周期，从程序创建到程序销毁
// 全局变量和局部变量同名，使用时根据就近原则访问
int global_b  = 10;


// 静态全局变量
// 可以在本文件中使用，不可以在其他文件中使用
// 生命周期，从程序创建到程序销毁
static global_static_b = 20;

void changeB(){
    global_b  = 999;
}

void testStatic(){

    int b = 10;
    b++;
    printf("the b  = %d \n", b);


    // 静态局部变量的作用域在函数内部
    // 从程序创建到程序销毁
    static int sb  = 10;  // static 修饰的变量不会被销毁，只创建一次，可以多次赋值
    sb ++;
    printf("the sb = %d \n",sb);
}



void test1_main() {

    auto int a = 10;
    // 局部变量的生周在方法内，作用域在也方法内
    printf("局部变量 a = %d \n", a);

    changeB();
    printf("全局变量 global_b = %d \n", global_b);

    printf("DEFINE_VAR_A = %d \n", DEFINE_VAR_A);

    for (int i = 0; i < 5; ++i) {
        testStatic();
    }


}
//
// Created by jun shen on 2020/4/19.
//
#include <stdio.h>

void const_main(){

    const int a = 100;
//    a = 200;

    int* p = &a;

    *p = 200;

    // 这里因为 a 是 const 修饰的，所以指针无法修改a的值
    printf("const_main %d \n" ,a);
    printf("const_main %d \n" ,*p);


    // example
    char str1[] ="Hello";
    char str2[] = "world";

    // 指向常量的指针
    const char* p1 = str1;

//    *p1 = 'h';     // 这里会报错，const 修改，无法修改值
    printf("the p1 = %s \n", p1);
    p1 = str2;
    printf("the p1 = %s \n", p1);

    // 常量指针
    char* const p2  = str1;

//    p2 = str2;    //报错  const

    printf("the p2 = %s \n", p2);



}

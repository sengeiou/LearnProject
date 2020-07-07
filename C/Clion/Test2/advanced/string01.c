//
// Created by Administrator on 2020/4/16.
//
#include <stdio.h>

void exchange(){
    char* arr[]  = {"Hello", "Worddddddddd","cocoa"};
    char* temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;

    for(int i = 0; i < 3; i++){
        printf("the str %d = %s \n", i , arr[i]);
    }
}

long str_len(const char* str){

//    *(str) = 'a';   const修饰的，不允许这么操作
    char* temp = str;
    while(*temp != '\0') {
        temp++;
    }
    return temp - str;
}




void string01_main() {

    char arr[] = "Hello world";
    char *p = "Hello world";

    arr[0] = 'g';   // 可以操作并能修改成功
//    p[0] = 'g';     // 这里会报错，因为char* 的字符串是存储在常量池中的，

    printf("arr = %s \n", arr);
    printf("p = %s \n", p);

    exchange();

    printf(" the str_len function testing\n");
    long len  = str_len(p);
    printf("the str_len is = %d\n", len);

}










#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Person{
    char name[20];
    int age;
    char address[40];
};


int main(){


    // 创建结构体变量并初始化
    struct Person p = {"testname",12,"zhejianghangzhou...."};

    //创建结构体变量，注意不要写反 
    struct Person p1;

    // p1.name = "123";   // 这里会报错
    strcpy(p1.name,"123");
    p1.age = 12;
    // p1.address = "zhejiang";//这里会报错
    strcpy(p1.address,"zhejiang");
    
    return EXIT_SUCCESS;
}
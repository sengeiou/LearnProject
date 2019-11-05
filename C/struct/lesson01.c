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

    // print 64 , 40 + 20 + 4
    printf("the sizeof struct Person %ld\n", sizeof(p));
    printf("the sizeof struct Person %ld\n", sizeof(p1));

    struct Person arr[3] = {
        {"123",12,"123"},       
        {"123",12,"123"},       
        {"123",12,"123"},       
    };

    
    return EXIT_SUCCESS;
}
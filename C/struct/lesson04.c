#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct person {
    char name[40];
    int age;   
};

typedef struct person Person;


// 结构体和指针的赋值，取值
int main(){

    Person *p1 = (Person*) malloc(sizeof(Person));
    (*p1).age = 18;
    strcpy((*p1).name,"cocoa");

    printf("the person age is %d and name is %s\n", p1 -> age , p1 -> name);
    //https://www.bilibili.com/video/av55251178/?p=33

}
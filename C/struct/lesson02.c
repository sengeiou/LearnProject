#include <stdio.h>
#include <stdlib.h>


// 定义结构体类型别名
typedef struct person Person;

struct person {
    char name[20];
    int age;
};


/**
 * 1. 在堆空间上创建结构体 
 * 
 * 
 */
int main(){

    struct person* p0 = (struct person*) malloc(sizeof(struct person));

    // 使用别名类型创建堆空间的结构体
    Person *p1 = (Person*) malloc(sizeof(Person) * 3);


    return EXIT_SUCCESS;
}


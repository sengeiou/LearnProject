//
// Created by jun shen on 2020/4/13.
//

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>


struct Person{
    char *name;
    int age;
    int height;
    int weight;
};

struct Person *Person_create(char *name ,int age , int height , int weight){

    struct Person *person = malloc(sizeof(struct Person));
    person -> name  = strdup(name);
    person -> age  = age;
    person -> height = height;
    person -> weight = weight;

    return person;
}


void destory(struct Person *p){
    free(p -> name);
    free(p);
    p = NULL;
}




void test(){
    struct Person *p = Person_create("cocoacocoacocoacocoacocoacocoacocoacocoacocoacocoacocoacocoa",16,100,100);

    int a = 1;
    int *p1  = &a ;
    printf("the size of the int %ld \n",sizeof(int));

    printf("the size of the person name %ld \n",sizeof(p-> name));
    printf("the person pointer is %ld \n", sizeof(struct Person));
    printf("the person pointer is %ld \n", sizeof(a));
//    printf("the name is %s \n",p -> name);
    assert(p != NULL);
    destory(p);
    free(p1);
    p1 = NULL;
}
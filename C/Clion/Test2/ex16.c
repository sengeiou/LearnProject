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


void test(){
    struct Person *p = Person_create("cocoa",16,100,100);

    int a = 1;
    int *p1  = &a ;
    printf("the person pointer is %ld \n", sizeof(p1));
    printf("the person pointer is %ld \n", sizeof(a));
    printf("the name is %s \n",p -> name);
    assert(p != NULL);
    free(p->name);
    free(p);
    free(p1);
   p1 = NULL;
    p = NULL;
}
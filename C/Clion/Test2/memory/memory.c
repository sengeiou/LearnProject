//
// Created by jun shen on 2020/4/19.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void test1(){
    int* pp = (int*) malloc(sizeof(int)*10);
    memset(pp,1, sizeof(int)*10);
    for (int i = 0; i < 10 ; ++i) {
        printf("=====%d\n",*(pp+i));
    }
}

void memory_main(){

    test1();

    int* p = (int*)malloc(sizeof(int));

    *p = 100;

    printf("the p = %d\n",*p);
    printf("the &p = %p\n",p);


}


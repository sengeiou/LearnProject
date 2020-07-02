//
// Created by Administrator on 2020/7/2.
//
#include "stdio.h"

#define  TWO 2

#define PRINT_TWO printf("THIS IS PRINT FROMA #define %d\n",TWO)
#define DIV(X,Y) ((X*Y)/2)

void pre_main(){


    printf("\nthis is content pre_main\n");
    printf("%d \n",TWO);


    PRINT_TWO;
    printf("use #defined function DIV = %d\n", DIV(1,2));




}
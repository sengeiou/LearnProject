//
// Created by Administrator on 2020/7/13.
//

#include <stdio.h>

#define ARRAY_SIZE(x) ( sizeof(x) / sizeof((x)[0]) )

void jiqiao_main(){

    int a = NULL;
    a = a ?: 10;
    if(!a){
        printf("error");
    }
    printf("the a  = %d \n",a );


    int array[] = {1,2,3};

    int size = ARRAY_SIZE(array);

    printf("the size of array = %d \n ", size);

}
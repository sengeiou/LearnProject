//
// Created by Administrator on 2020/4/14.
//

#include <stdio.h>


void string_main() {
    char *name1 = "cocoa";
    char *name2 = "cocoa";
    const char *name3 = "cocoa123";
    printf("the pointer name1 = %p \n", name1);
    printf("the pointer name2 = %p \n", name2);
    printf("the char of name1 %c \n", *name1);

    printf("the char of name1 %c \n", *(++name1));
    printf("the char of name1 %c \n", *(++name1));
    // 指针位移后出现的问题

    printf("the char of name1 %s \n", name1);

//      name3[1] = 'a';
    name3 = name1;
    printf("the name3 is %s \n", name3);

    const char strArr[] = "123";




}
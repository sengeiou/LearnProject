#include <stdio.h>
#include <string.h>
#include <stdlib.h>
 
void test(char* c){
    printf("%c \n", *c);
}

void test1(int a , char* c){
    printf("%c \n", *(c+1));
}


/**
 * C 专家编程中说， 作为函数第一个参数的数组，会被转化为指针，
 * 这里做了测试，发现即使不是第一个，也是会被编译器转化为数组的 
 *
 */
int main(){

    char str[] = "Hello world";
    test1(1,str);
    return 0;
}

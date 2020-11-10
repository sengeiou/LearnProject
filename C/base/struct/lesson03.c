#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct House{
    char address[40];
};

struct Person{
    struct House h;
    char name[20];
    int age;
};


/**
 *  1. 结构体嵌套结构体 
 * 
 * 
 */
int main(){

    struct Person p  = {"zhejianghangzhou","cocoa",123};

    printf("the address %s \n", p.h.address);

    return EXIT_SUCCESS;
}

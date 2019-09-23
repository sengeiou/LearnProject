#include <stdio.h>

struct Person{
    int age;
    char name[20];
} person;


int main(){
    int a = 10;
    int b = 20;

    int* const p =  &a;
    *p = 20;
    printf("a =  %d \n", a);

    int a1 = 111;
    const int* p1 = &a1; 
    p1 = &b;


    return 0;
}
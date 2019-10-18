#include <stdio.h>

int a  = 10;
int* test(){
    return &a;
}

int main(){
    int* p  = test();
    printf("%d\n",*p);
    return 0;
}
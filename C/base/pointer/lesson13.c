#include <stdio.h>

void swap(int* a , int* b){
    int t = *a;
    *a  = *b;
    *b  = t;
}

// 值传递和地址传递
int main(){
    int a  = 10;
    int b  = 20;
    swap(&a, &b);
    printf("a = %d and b = %d\n", a, b);
    return 0;
}
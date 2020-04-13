#include <stdio.h>
#include "test.h"
#define VALUE 10

#define MAX(a,b) ((a > b) ? (a) : (b))

int main() {
    printf("Hello, World!\n");
    printf("this is ten %d \n", VALUE);

    int a = MAX(10,20);
    printf("this is max method %d \n",a);

    int array[7] = {1,2,3,4,5,6,7};

    printf("%p \n", array);
    int *p = &array;
    for (int i = 0 ; i < 7 ; i++) {
        printf("%p \n", p + i);
        printf("%d \n", *(p+i));
    }

    printf("the a size of %zd \n", sizeof a);
    getArraySize(array);

    int total = sum(p, p+7);
    printf("the sum is %d \n", total );

    printf("the size of  pointer %lu \n", sizeof(char*));
    return 0;
}

void test1(const int arr[] ){
//    arr[0] += 1
}



int sum(int *start ,int *end){
    int total = 0;
    while( start < end){
        total += *start ;
        start ++;
    }
    return total;
}

int getArraySize(int arr[]){
    printf("the size of arr %d \n", sizeof arr);
}
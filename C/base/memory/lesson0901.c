#include <stdio.h>
#include <stdlib.h>

// 这里是值传递，所以即使p 初始化成功了，也会在方法执行后销毁
void makePointer(int* p){
    p = (int*)malloc(sizeof(int));
    printf("the poniter @ makePointer function %p \n",p);
}


// 对 makePointer 进行优化, 传递的二级指针，则可以正常运行，或者还有一个办法，用 return 返回指针
void makePointerOpt(int** p){
    *p = (int*)malloc(sizeof(int));
    printf("the poniter @ makePointer function %p \n",p);
}


int main(){

    int* p = NULL;
    makePointerOpt(&p);
    printf("the poniter @ main function %p \n",p);

    return EXIT_SUCCESS;
}
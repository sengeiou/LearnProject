#include <stdio.h>

#define pf printf

int main(){

    pf("the size of char %d \n",sizeof(char));
    pf("the size of short %d \n",sizeof(short));
    pf("the size of int %d \n",sizeof(int));
    pf("the size of float %d \n",sizeof(float));
    pf("the size of long %d \n",sizeof(long));
    pf("the size of double %d \n",sizeof(double));
    

    
    int a  = 1;    
    int *p  = &a;
    // 指针类型的大小是固定的（无论该指针指向哪种数据类型），在32位系统中为4字节；在64位系统中为8字节
    pf("the size of pointer %d \n",sizeof(p));





}
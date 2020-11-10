#include <stdio.h>

// 用指针访问修改变量的值
int main(){

        int i = 10;
        int *p  = &i;

        printf("i = %d \n", i);

        printf("*p= %d \n", *p);

        *p =20;

        printf("i =  %d \n", i);

        printf("*p=  %d \n", *p);

        i = 30;

        printf("i =  %d \n", i);

        printf("*p=  %d \n", *p);



        return 0;
}

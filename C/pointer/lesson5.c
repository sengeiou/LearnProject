#include <stdio.h>


// 用指针来访问值
int main(){

        int a = 10;
        int *p = &a;

        // 用*指针 来读取保存在 指针变量的值
        printf("%d\n", *p);
        printf("%p\n", p);
        printf("%p\n", &a);
        return 0;
}

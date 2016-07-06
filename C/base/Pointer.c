#include <stdio.h>

int main()
{

        int num1 = 1100;
        int num2 = 1200;
        int *p = &num1;   //P的值存储一个地址，占4个字节
        p = &num2;

        *p = 110;


        printf("%d\n", sizeof(p));

        printf("%p\n", p);

        printf("%d\n", *p);

        printf("%d\n", &p);

        return 0;
}

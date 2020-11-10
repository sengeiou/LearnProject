#include <stdio.h>

int main()
{
    char *c = "cocoa";
    //  *c  = 'C';     // 指针指向的字符串是在字符串常量中，无法进行修改

    char *p = "cocoa";

    printf("%p\n", c);  // c 和 p 的指针都是指向同一个地址
    printf("%p\n", p);

    char c1[] = "1231231";
    c1[0] = 'C';
    printf("%s\n", c1);
    return 0;
}
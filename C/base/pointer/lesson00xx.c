#include <stdio.h>

int main()
{
    char *str = "hello world"; // 数据常量区
    char *str1 = "hello world";
    // *(str+1) = 'c';  // 错误

    printf("%p \n", str);
    printf("%p \n", str1);   // str 和 str2 的地址是一样的

    printf("%s \n", str);
}
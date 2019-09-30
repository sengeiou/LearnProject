#include <stdio.h>

// p66 指针运算
// 字符串拷贝
void change(char *s, char *t)
{
    int i = 0;
    while (*(s+i))
    {
        *(t + i) = *(s + i);
        i++;
    }
    *(t + i) = 0;
}
// 更便捷的写法，指针++
void change2(char* s, char* t){
    while (*s)
    {
        *t = *s;
        t++;
        s++;
    }
    *t = 0;
}



int main(void)
{
    char *source = "cocoa";
    char tag[100];
    change2(source, tag);
    printf("%s\n", tag);
    return 0;
}
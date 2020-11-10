#include <stdio.h>
#include <stdlib.h>

int main()
{


    //开辟堆内存空间
    int*  p = (int*)malloc(sizeof(int));
    printf("%p\n",p);

    // 使用堆空间
    *p = 123;

    // 释放堆空间
    free(p);
    p = NULL;

    int strLength = 5;
    char* s = (char*)malloc(sizeof(char)* strLength);
    int count  = 0;
    while(count < strLength){
        *(s+count) = 'a';
        count++;
    }
    printf("the str is %s \n",s);

    free(s);
    s = NULL;


    return EXIT_SUCCESS;
}
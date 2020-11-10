#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// 多次改变指针后，导致指针无法释放
void test3(){
    int* p3 = (int*) malloc(sizeof(int)*10);
    for (int i = 0; i < 10; i++)
    {
        *p3 = i;
        p3++;
    }
    free(p3);    
}

// 多次改变指针的优化方案
void opttest3(){

    int* p3 = (int*) malloc(sizeof(int)*10);
    int* temp = p3;    
    for (int i = 0; i < 10; i++)
    {
        *temp = i;
        temp++;
    }
    free(p3);    


}




int main()
{

    char *c1 = (char *)malloc(10 * sizeof(char));
    strcpy(c1, "HELLO WORLD!!"); // 1数组下表越界, 也能正常运行，但是不要这么这么做
    printf("%s \n", c1);
    // free(c1);   // 释放内存会报错

    // 2野指针问题, 不要这么做
    int *p1 = (int *)malloc(0);
    *p1 = 1000;
    printf("%d \n", *p1);
    printf("%p \n", p1);

    // 3不要这么做   
    int *p2 = (int *)malloc(10);
    *p2 = 111;
    *(p2 + 1) = 222;
    *(p2 + 2) = 333;

    printf("p2 %d \n",*(p2 + 2));    

    // 堆空间不要多次释放
    int* p = (int*) malloc(sizeof(int));
    free(p);  // 释放后，p变为野指针，在次free 后，会报错
    //free(p);// 会报错，可以在第一个free 后把 p= NULL; 因为空指针可以多次释放，野指针则不行

    // test3();
    opttest3();

    // C 语言是值传递    


    return EXIT_SUCCESS;
}
#include <stdio.h>

// 野指针，空指针
int main()
{

        // 指针变量指向未知的空间，10000的地址未知（啥类型？是否可以访问?）
        // initialization makes pointer from integer without a cast
        // 不建议将一个变量的值直接赋值给指针
        // int *p = 200;

        int *p1 = NULL;
        printf("%p\n", p1); // nil
        if (p1 == NULL)
        {
                printf("P1 = null！\n");
        }
        //空指针的读写都会报错。
        // 尝试读取空指针，报错
        printf("%d\n",*p1);
        return 0;
}

#include <stdio.h>

void fun01()
{
    // 生命周期 ，整个程序
    // 作用域 ， 函数内部
    static int a = 1; // 只会初始化一次
    a++;
    printf("the a iun fun01 %d \n", a);
}

// 静态变量
int main()
{

    static int a = 10;
    printf("%d\n", a);
    for (int i = 0; i < 10; i++)
    {
        // 依次打印 2 ,3 4 .....
        // 因为fun01 中的 a 是静态的
        fun01();
    }

    return 0;
}